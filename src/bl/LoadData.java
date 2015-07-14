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
        counter = 0;
        cRow = 0;
        rowCounter = -1;
        rc = "";
        allTables.clear();
        while ((str = br.readLine()) != null) {
            if (str.equals(tableDelim)) {
                counter = 1;
            }
            else if(str.equals("endDatabase"))
            {
                onCreateTable();
                return allTables;
            }
            else {
                if (counter == 1) {
                    onCreateTable();
                    strArray = str.split(delim);
                    System.out.println(tablename);
                    tablename = strArray[0];
                    rowCounter = Integer.parseInt(strArray[1]);
                    counter = 2;
                } else if (rowCounter != -10) {
                    if (counter == 2) {
                        strArray = str.split(delim);
                        for (String array1 : strArray) {
                            columns.add(array1);
                        }
                        counter++;
                    } else {

                        strArray = str.split(delim);
                        for (String array1 : strArray) {
                            Row r = new Row(cRow, array1);
                            rows.add(r);
                        }
                        cRow++;
                    }
                }
            }
        }
        br.close();
        System.out.println(allTables.size());
        return allTables;
    }

    public void onCreateTable() {
        Table table = new Table(tablename, Integer.toString(rowCounter), columns, rows);
        allTables.add(table);
        cRow = 0;
        tablename = "";
        columns.clear();
        rows.clear();
        c = 0;
    }
}
