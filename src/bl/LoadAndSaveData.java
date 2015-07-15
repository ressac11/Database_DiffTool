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
public class LoadAndSaveData 
{
    private final String tableDelim = "#end#";
    private final String delim = "#";

    private String str;
    private String[] strArray;
    private String tablename = "";
    private LinkedList<String> columns = new LinkedList<>();
    private LinkedList<Row> rows = new LinkedList<>();
    private int counter;
    private int cRow;
    private int c;
    private int rowCounter;
    private String rc;
    private LinkedList<Table> allTables = new LinkedList<>();

    public LinkedList<Table> loadData(File f) throws FileNotFoundException, IOException 
    {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        counter = 0;
        cRow = 0;
        rowCounter = -1;
        rc = "";
        allTables.clear();
        
        while ((str = br.readLine()) != null) 
        {
            if (str.equals(tableDelim)) 
            {
                counter = 1;
            }
            else if(str.equals("endDatabase"))
            {
                onCreateTable();
                return allTables;
            }
            else 
            {
                if (counter == 1) 
                {
                    onCreateTable();
                    strArray = str.split(delim);
//                    System.out.println(tablename);
                    tablename = strArray[0];
                    rowCounter = Integer.parseInt(strArray[1]);
                    counter = 2;
                } 
                else if (rowCounter != -10) 
                {
                    if (counter == 2) 
                    {
                        strArray = str.split(delim);
                        for (String array1 : strArray) 
                        {
                            columns.add(array1);
                        }
                        counter++;
                    } 
                    else 
                    {
                        strArray = str.split(delim);
                        for (String array1 : strArray)
                        {
                            Row r = new Row(cRow, array1);
                            rows.add(r);
                        }
                        cRow++;
                    }
                }
            }
        }
        br.close();
//        System.out.println(allTables.size());
        return allTables;
    }

    public void onCreateTable() 
    {
        Table table = new Table(tablename, Integer.toString(rowCounter), columns, rows);
        allTables.add(table);
        cRow = 0;
        tablename = "";
        columns.clear();
        rows.clear();
        c = 0;
    }
    
    public void saveDatabaseFile(File f, LinkedList<Table> tables, String DatabaseName) throws IOException 
    {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = tables.iterator();

        while (it.hasNext()) 
        {
            Table table = it.next();
//            bw.newLine();
//            bw.write(DatabaseName);
            bw.newLine();
            bw.write(tableDelim);
            bw.newLine();
            bw.write(table.getTableName());
            bw.write(delim);
            bw.write(table.getRowCounter());
            bw.newLine();
            List<String> columns = table.getColumnNames();
            int c = 0;
            for (String column : columns) 
            {
                bw.write(column + delim);
                c++;
                if (c == columns.size()) 
                {
                    bw.newLine();
                }
            }

            List<Row> rows = table.getAttributes();
            Row oldValue = rows.get(0);
            bw.write(oldValue.getValue() + delim);

            for (int i = 1; i < rows.size(); i++)
            {
                Row r2 = rows.get(i);
                if (r2.getRID() != oldValue.getRID()) 
                {
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
