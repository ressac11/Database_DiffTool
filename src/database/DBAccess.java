/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.Row;
import beans.Table;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Sarah
 */
public class DBAccess {

    private DBConnectionPool connPool;
    private static DBAccess theInstance = null;
    private LinkedList<Table> liAllTables = new LinkedList<>();

    public static DBAccess getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBAccess();
        }
        return theInstance;
    }

    private DBAccess() throws ClassNotFoundException {
        connPool = DBConnectionPool.getTheInstance();
    }

    public LinkedList<Table> getAllTables(LinkedList<Table> liAllTables) throws Exception {
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT table_name "
                + " FROM information_schema.tables "
                + " WHERE table_schema = 'public' ";
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String tableName = rs.getString(1);
            LinkedList<String> columnNames = getColumnNames(tableName);
            LinkedList<Row> liAttributes = getAttributesForOneTable(tableName, columnNames);
            liAllTables.add(new Table(tableName, columnNames, liAttributes));
        }
        this.liAllTables = liAllTables;
        return liAllTables;
    }

    public LinkedList<String> getColumnNames(String tableName) throws Exception {
        LinkedList<String> columnNames = new LinkedList<>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "select column_name from information_schema.columns where "
                + " table_name='" + tableName + "'";
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String colName = rs.getString(1);
            columnNames.add(colName);
        }
        return columnNames;
    }

    public LinkedList<Row> getAttributesForOneTable(String tableName, LinkedList<String> columnNames) throws Exception {
        LinkedList<Row> liAttributes = new LinkedList<Row>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT * "
                + " FROM " + tableName + " ";
        int count = 0;
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) 
        {
            for (int i = 0; i < columnNames.size(); i++) 
            {
                String str = rs.getString(i + 1);
                Row r = new Row(count, str);
                liAttributes.add(r);
            }
            count++;
        }
        return liAttributes;
    }

    public void saveDatabaseFile(File f) throws IOException 
    {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = liAllTables.iterator();

        while (it.hasNext()) 
        {
            Table table = it.next();
            bw.write(table.getTableName());
            System.out.println("Name: "+table.getTableName());
            bw.newLine();
            List<String> columns = table.getColumnNames();
            int c = 0;
            for (String column : columns) 
            {
                bw.write(column + "#");
                c++;
                if (c == columns.size()) 
                {
                    bw.newLine();
                }
            }
            
            List<Row> rows = table.getAttributes();
            Row rAlterWert = rows.get(0);
            bw.write(rAlterWert.getValue() + "#");
            
            for (int i = 1; i < rows.size(); i++) 
            {
                Row r2 = rows.get(i);
                if (r2.getRID() != rAlterWert.getRID()) 
                {
                    bw.newLine();
                    rAlterWert = r2;
                    //System.out.println("alte rid: "+rAlterWert.getRID() + "      neue rid: "+);
                }
                bw.write(r2.getValue() + "#");             
            }
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }

//    public void loadData(String fileName) {
//
//        FileReader fr = new FileReader(fileName);
//
//        BufferedReader br = new BufferedReader(fr);
//
//        String str =
//        ““;
//
//        String[] strArray;
//
//        while ((str = br.readLine()) != null) {
//
//            strArray = str.split(delim);
//
//            Objekt obj = new Objekt(strArray[0], strArray[1]);
//
//            liste.add(obj);
//
//        }
//        br.close;
//
//        fireTableRowsInserted(0, liste.size() - 1);
//
//    }
}
