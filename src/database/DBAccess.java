/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.Row;
import beans.Table;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Sarah
 */
public class DBAccess {
    private DBConnectionPool connPool;
    private static DBAccess theInstance = null;
    
   
    public static DBAccess getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBAccess();
        }
        return theInstance;
    }

    private DBAccess() throws ClassNotFoundException {
        connPool = DBConnectionPool.getTheInstance();
    }
    
    
    
    public LinkedList<Table> getAllTables(LinkedList<Table> liAllTables) throws Exception
    {     
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT table_name "
                + " FROM information_schema.tables "
                + " WHERE table_schema = 'public' ";
        ResultSet rs = stat.executeQuery(sqlString);
        while(rs.next())
        {
            String tableName = rs.getString(1);
            LinkedList<String> columnNames = getColumnNames(tableName);
            LinkedList<Row> liAttributes = getAttributesForOneTable(tableName, columnNames);
            liAllTables.add(new Table(tableName, columnNames, liAttributes));
        }
        return liAllTables;
    }   
    
    public LinkedList<String> getColumnNames(String tableName) throws Exception
    {
        LinkedList<String> columnNames = new LinkedList<>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "select column_name from information_schema.columns where " +
                            " table_name='"+tableName+"'";
        ResultSet rs = stat.executeQuery(sqlString);
        while(rs.next())
        {
            String colName = rs.getString(1);
            columnNames.add(colName);
        }
        return columnNames;
    }
    
    public LinkedList<Row> getAttributesForOneTable(String tableName, LinkedList<String> columnNames) throws Exception
    {
        LinkedList<Row> liAttributes = new LinkedList<Row>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();       
        String sqlString = "SELECT * "
                + " FROM "+tableName+" ";
        ResultSet rs = stat.executeQuery(sqlString);
        while(rs.next())
        {
            for (int i = 0; i < columnNames.size(); i++) 
            {
                String str = rs.getString(i+1);
                Row r = new Row(i, str);
                liAttributes.add(r);
            }   
        }  
        return liAttributes;
    }
    
}
