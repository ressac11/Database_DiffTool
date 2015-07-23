package database;

import beans.Row;
import beans.Table;
import gui.DatabaseConnectionDialogue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class DBAccess {

    private DBConnectionPool connPool;
    private static DBAccess theInstance = null;
    private LinkedList<Table> liAllTables = new LinkedList<>();
    private static final String tableDelim = "#end#";
    private static final String delim = "#";
    private String rowCounter;

    public static DBAccess getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) 
        {
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
        String sqlString = "";
        switch (DatabaseConnectionDialogue.selectedDB) {
            case "postgres":
                sqlString = "SELECT table_name "
                        + " FROM information_schema.tables "
                        + " WHERE table_schema = 'public' ";
                break;
            case "oracle":
                sqlString = "SELECT table_name "
                        + "  FROM dba_tables where owner='" + DBConnectionPool.DB_USER + "'";
                break;
            case "mssql":
                sqlString = "SELECT TABLE_NAME "
                        + "FROM INFORMATION_SCHEMA.TABLES "
                        + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_CATALOG='" + DBConnectionPool.DB_NAME + "'";
                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String tableName = rs.getString(1);
            LinkedList<String> columnNames = getColumnNames(tableName);
            LinkedList<Row> liAttributes = getAttributesForOneTable(tableName, columnNames);
            liAllTables.add(new Table(tableName, rowCounter, columnNames, liAttributes));
        }
        this.liAllTables = liAllTables;
        return liAllTables;
    }

    public LinkedList<String> getColumnNames(String tableName) throws Exception {
        LinkedList<String> columnNames = new LinkedList<>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "";

        switch (DatabaseConnectionDialogue.selectedDB) {
            case "postgres":
                sqlString = "select column_name from information_schema.columns where "
                        + " table_name='" + tableName + "'";
                break;
            case "oracle":
                sqlString = "select column_name from all_tab_cols where table_name = '" + tableName + "'"
                        + "and owner = '" + DBConnectionPool.DB_USER + "'";
                break;
            case "mssql":
                sqlString = "SELECT TABLE_NAME "
                        + "FROM INFORMATION_SCHEMA.TABLES "
                        + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_CATALOG='" + DBConnectionPool.DB_NAME + "'";
                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String colName = rs.getString(1);
            columnNames.add(colName);
        }
        return columnNames;
    }
    
    public void testConnection() throws SQLException
    {
        Connection conn = connPool.getConnection();
    }

    public LinkedList<Row> getAttributesForOneTable(String tableName, LinkedList<String> columnNames) throws Exception {
        LinkedList<Row> liAttributes = new LinkedList<Row>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT * "
                + " FROM " + tableName + " ";
        int count = 0;
        ResultSet rs = stat.executeQuery(sqlString);
        String value = "";
        while (rs.next()) {
            for (int i = 0; i < columnNames.size(); i++) {
                String str = rs.getString(i + 1);
                value += str + ";";
            }
            Row r = new Row(count, value);
            liAttributes.add(r);
            value = "";
            count++;
        }
        sqlString = "SELECT COUNT(*) FROM " + tableName + " ";
        rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            rowCounter = rs.getString(1);
        }
        return liAttributes;
    }
}