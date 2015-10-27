package database;

import beans.Row;
import beans.Table;
import gui.DatabaseConnectionDialogue;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DBAccess 
{

    private final DBConnectionPool connPool;
    private static DBAccess theInstance = null;
    private LinkedList<Table> liAllTables = new LinkedList<>();

    /**
     * for creating an instance from the class DBAccess
     *
     * @return theInstance
     * @throws ClassNotFoundException
     */
    public static DBAccess getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBAccess();
        }
        return theInstance;
    }

    private DBAccess() throws ClassNotFoundException {
        connPool = DBConnectionPool.getTheInstance();
    }

    /**
     * This method is responsible for creating a list which holds all tables in
     * one database.
     *
     * @param liAllTables
     * @return LinkedList<Table> all Tables at the Database
     * @throws Exception
     */
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
            String primaryColumn = getPrimaryKeyColumn(tableName);
            LinkedList<Row> liAttributes = getAttributesForOneTable(tableName, columnNames, primaryColumn);
            liAllTables.add(new Table(tableName, columnNames, liAttributes));
        }
        rs.close();
        connPool.releaseConnection(conn);
        this.liAllTables = liAllTables;
        return liAllTables;
    }

    public LinkedList<String> getAllTableNames() throws Exception {
        LinkedList<String> allTableNames = new LinkedList<>();
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
            allTableNames.add(rs.getString(1));
        }
        rs.close();
        connPool.releaseConnection(conn);
        return allTableNames;
    }
    
    public LinkedList<Table> getSpecificTables(LinkedList<String> liTableNames, LinkedList<Table> tables) throws Exception
    {
        liAllTables.clear();
        for (int i = 0; i < liTableNames.size(); i++) 
        {
            LinkedList<String> columnNames = getColumnNames(liTableNames.get(i));
            String primaryColumn = getPrimaryKeyColumn(liTableNames.get(i));
            LinkedList<Row> liAttributes = getAttributesForOneTable(liTableNames.get(i), columnNames, primaryColumn);
            tables.add(new Table(liTableNames.get(i), columnNames, liAttributes));
        }
        return tables;
    }

    /**
     * Because of this method we are getting the column names thorugh the table
     * name
     *
     * @param tableName
     * @return LinkedList<String> column names from one table
     * @throws Exception
     */
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
                sqlString = "SELECT COLUMN_NAME "
                        + "FROM INFORMATION_SCHEMA.COLUMNS "
                        + "WHERE TABLE_NAME = '" + DBConnectionPool.DB_NAME + "' ";

                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String colName = rs.getString(1);
            columnNames.add(colName);
        }
        rs.close();
        connPool.releaseConnection(conn);
        return columnNames;
    }

    public String getPrimaryKeyColumn(String tableName) throws Exception {
        String primaryColumn = "";
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "";

        switch (DatabaseConnectionDialogue.selectedDB) {
            case "postgres":
                sqlString = "SELECT a.attname "
                        + "FROM   pg_index i "
                        + "JOIN   pg_attribute a ON a.attrelid = i.indrelid "
                        + "                     AND a.attnum = ANY(i.indkey) "
                        + "WHERE  i.indrelid = '" + tableName + "'::regclass "
                        + "AND    i.indisprimary;";
                break;
            case "oracle":
                sqlString = "SELECT cols.column_name "
                        + "FROM all_constraints cons, all_cons_column cols "
                        + "WHERE cols.table_name='" + tableName.toUpperCase() + "' "
                        + "AND cons.constraint_type='P' "
                        + "AND cons.constraint_name=cols.constraint_name "
                        + "AND cons.owner = cols.owner;";
                break;
            case "mssql":
                sqlString = "SELECT KU.table_name as tablename,column_name as primarykeycolumn "
                        + "FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS TC "
                        + "INNER JOIN "
                        + "INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS KU "
                        + "ON TC.CONSTRAINT_TYPE = 'PRIMARY KEY' AND "
                        + "TC.CONSTRAINT_NAME = KU.CONSTRAINT_NAME "
                        + "and ku.table_name='" + tableName + "' "
                        + "ORDER BY KU.TABLE_NAME, KU.ORDINAL_POSITION;";
                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            primaryColumn = rs.getString(1);
        }
        rs.close();
        connPool.releaseConnection(conn);
        return primaryColumn;
    }

    /**
     * The aim of this method is to return all the values which are in one
     * Table. Every attribute from the list holds one row at the certain table.
     * The values are seppareted through a ';'.
     *
     * @param tableName
     * @param columnNames
     * @return LinkedList<Row> all values which are in one row
     * @throws Exception
     */
    public LinkedList<Row> getAttributesForOneTable(String tableName, LinkedList<String> columnNames, String primaryColumn) throws Exception {
        LinkedList<Row> liAttributes = new LinkedList<Row>();
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT * "
                + " FROM " + tableName + " ";
        ResultSet rs = stat.executeQuery(sqlString);
        int count = 0;
        String value = "";
        String pK = "";
        while (rs.next()) {
            for (int i = 0; i < columnNames.size(); i++) {
                if (columnNames.get(i).equals(primaryColumn)) {
                    pK = rs.getString(i + 1);
                    value += pK + ";";
                } else {
                    try {
                        String str = rs.getString(i + 1);
                        value += str + ";";
                    } catch (Exception ex) {
                        value += "<blob>" + ";";
                    }
                }
            }
            Row r = new Row(count, value, pK);
            liAttributes.add(r);
            value = "";
            count++;
        }
        rs.close();
        connPool.releaseConnection(conn);
        return liAttributes;
    }
  
}
