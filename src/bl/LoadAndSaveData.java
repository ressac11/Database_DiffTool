/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import beans.Row;
import beans.Table;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class LoadAndSaveData {

    private final String tableDelim = "#end#";
    private final String delim = "#";
    private String str;
    private String[] strArray;
    private String tablename = "";
    private LinkedList<String> columns = new LinkedList<>();
    private int counter;
    private String rowCounter;
    private LinkedList<Table> allTables = new LinkedList<>();

    public LinkedList<Table> loadData(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        counter = -1;
        allTables.clear();
        tablename = "";
        LinkedList<Row> liRows = new LinkedList<>();
        while ((str = br.readLine()) != null) {
            if (counter != -1) {
                if (counter == 0) {
                    if (str.equals("#end#")) {
                        counter = 0;
                    } else {
                        tablename = str.split("#")[0];
                        rowCounter = str.split("#")[1];
                        counter = 1;
                    }
                } else if (counter == 1) {
                    strArray = str.split("#");
                    for (int i = 0; i < strArray.length; i++) {
                        String str2 = strArray[i];
                        columns.add(str2);
                    }
                    counter++;
                } else {
                    if (str.equals("#end#")) {
                        LinkedList<String> c2 = new LinkedList<>(columns);
                        LinkedList<Row> r2 = new LinkedList<>(liRows);
                        counter = 0;
                        Table t = new Table(tablename, rowCounter, c2, r2);
                        allTables.add(t);
                        columns.clear();
                        liRows.clear();

                        tablename = "";
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

    public void saveDatabaseFile(File f, LinkedList<Table> tables, String DatabaseName) throws IOException {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = tables.iterator();

        while (it.hasNext()) {
            Table table = it.next();
            bw.newLine();
            bw.write(tableDelim);
            bw.newLine();
            bw.write(table.getTableName());
            bw.write(delim);
            bw.write(table.getRowCounter());
            bw.newLine();
            List<String> columns = table.getColumnNames();
            int c = 0;
            for (String column : columns) {
                bw.write(column + delim);
                c++;
                if (c == columns.size()) {
                    bw.newLine();
                }
            }
            List<Row> rows = table.getAttributes();
            Row oldValue = rows.get(0);
            bw.write(oldValue.getValue() + delim);

            for (int i = 1; i < rows.size(); i++) {
                Row r2 = rows.get(i);
                if (r2.getRID() != oldValue.getRID()) {
                    bw.newLine();
                    oldValue = r2;
                }
                bw.write(r2.getValue() + delim);
            }
        }
        bw.newLine();
        bw.write("endDatabase");
        bw.flush();
        bw.close();
    }
}
