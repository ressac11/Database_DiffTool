/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import beans.Row;
import beans.Table;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Sarah
 */
public class LoadData {

    private final String tableDelim = "#end#";
    private final String delim = "#";

    String str;
    String[] strArray;
    String tablename = "";
    LinkedList<String> columns = new LinkedList<>();
    LinkedList<Row> rows = new LinkedList<>();
    int counter;
    int cRow;
    int c;
    int rowCounter;
    String rc;
    LinkedList<Table> allTables = new LinkedList<>();

    public LinkedList<Table> loadData(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
//        counter = 0;
//        cRow = 0;
//        rowCounter = -1;
//        rc = "";
//        allTables.clear();
//        while ((str = br.readLine()) != null) {
//            if (str.equals(tableDelim)) {
//                counter = 1;
//            } else if (str.equals("endDatabase")) {
//                onCreateTable();
//                //return allTables;
//            } else {
//                if (counter == 1) {
//                    onCreateTable();
//                    columns.clear();
//                    rows.clear();
//                    strArray = str.split(delim);
//                    tablename = strArray[0];
//                    rowCounter = Integer.parseInt(strArray[1]);
//                    counter = 2;
//                } else if (rowCounter != -1) {
//                    if (counter == 2) {
//                        strArray = str.split(delim);
//                        for (String array1 : strArray) {
//                            columns.add(array1);
//                        }
//                        counter++;
//                    } else {
//                        strArray = str.split(delim);
//                        for (String array1 : strArray) {
//                            Row r = new Row(cRow, array1);
//                            rows.add(r);
//                        }
//                        cRow++;
//                    }
//                }
//            }
//        }

        counter = -1;
        allTables.clear();
        tablename = "";
        cRow = 0;
        LinkedList<Row> liRows = new LinkedList<>();
        while ((str = br.readLine()) != null) {
            if (counter != -1) {
                if (counter == 0) {
                    if (str.equals("#end#")) {
                        counter = 0;
                    } else {
                        tablename = str.split("#")[0];
                        cRow = Integer.parseInt(str.split("#")[1]);
                        System.out.println(tablename);
                        counter++;
                    }
                } else if (counter == 1) {
                    strArray = str.split("#");
                    for (int i = 0; i < strArray.length; i++) {
                        String str2 = strArray[i];
                        columns.add(str2);
                        System.out.print(str2 + " ");
                    }
                    System.out.println();
                    counter++;
                } else {
                    if (str.equals("#end#")) {
                        LinkedList<String> c2 = new LinkedList<>(columns);                    
                        counter = 0;
                        Table t = new Table(tablename, Integer.toString(rowCounter), c2, liRows);
                        allTables.add(t);
                        System.out.println("#end:  " + allTables.get(0).getAttributes().get(0).getValue());
                        columns.clear();
                        liRows.clear();
                        tablename="";
                        System.out.println("##end:  " + allTables.get(0).getAttributes().get(0).getValue());
                    } else {
                        Row r = new Row(counter, str.split("#")[0]);
                        liRows.add(r);
                    }

                }

            } else {
                counter++;
            }

        }

        br.close();
        return allTables;
    }   
}
