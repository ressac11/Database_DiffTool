package database;

import beans.Row;
import beans.Table;
import gui.DatabaseConnectionDialogue;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class DBAccess {

    private final DBConnectionPool connPool;
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
            liAllTables.add(new Table(tableName, columnNames, liAttributes));            
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
                String sql = "SELECT COLUMN_NAME "
                        + "FROM INFORMATION_SCHEMA.COLUMNS "
                        + "WHERE TABLE_NAME = '" + DBConnectionPool.DB_NAME + "' ";

                break;
        }
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
        ResultSet rs = stat.executeQuery(sqlString);
        int count = 0;
        String value = "";

        while (rs.next()) {
            for (int i = 0; i < columnNames.size(); i++) {
                try
                {
                    String str = rs.getString(i + 1);
                    value += str + ";";
                }catch(Exception ex)
                {
                    Blob b = rs.getBlob(i + 1);
                    String str = b.toString();
                    value += str + ";";
                }
            }
            Row r = new Row(count, value);
            liAttributes.add(r);
            value = "";
            count++;
        }
        rs.close();
        connPool.releaseConnection(conn);
        return liAttributes;
    }
}
