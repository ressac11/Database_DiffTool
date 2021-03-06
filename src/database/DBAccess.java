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

public class DBAccess {

    private final DBConnection conn;
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
        conn = DBConnection.getTheInstance();
    }
 
    public LinkedList<String> getAllTableNames() throws SQLException, NullPointerException {
        LinkedList<String> allTableNames = new LinkedList<>();
        Connection connect = conn.getConnection();
        Statement stat = connect.createStatement();
        String sqlString = "";
        switch (DatabaseConnectionDialogue.selectedDB) {
            case "postgres":
                sqlString = "SELECT table_name "
                        + " FROM information_schema.tables "
                        + " WHERE table_schema = 'public' ";
                break;
            case "oracle":
                sqlString = "SELECT table_name "
                        + "  FROM dba_tables where owner='" + DBConnection.DB_USER + "' ";
                break;
            case "mssql":
                sqlString = "SELECT TABLE_NAME "
                        + "FROM INFORMATION_SCHEMA.TABLES "
                        + "WHERE TABLE_TYPE = 'BASE TABLE' AND TABLE_CATALOG='" + DBConnection.DB_NAME + "'";
                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            allTableNames.add(rs.getString(1));
        }
        rs.close();
        return allTableNames;
    }

    public LinkedList<Table> getSpecificTables(LinkedList<String> liTableNames, LinkedList<Table> tables) throws SQLException {
        liAllTables.clear();
        for (int i = 0; i < liTableNames.size(); i++) {
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
    public LinkedList<String> getColumnNames(String tableName) throws SQLException {
        LinkedList<String> columnNames = new LinkedList<>();
        Connection connect = conn.getConnection();
        Statement stat = connect.createStatement();
        String sqlString = "";

        switch (DatabaseConnectionDialogue.selectedDB) {
            case "postgres":
                sqlString = "select column_name from information_schema.columns where "
                        + " table_name='" + tableName + "'";
                break;
            case "oracle":
                sqlString = "select column_name from all_tab_cols where table_name = '" + tableName + "'"
                        + "and owner = '" + DBConnection.DB_USER + "'";
                break;
            case "mssql":
                sqlString = "SELECT COLUMN_NAME "
                        + "FROM INFORMATION_SCHEMA.COLUMNS "
                        + "WHERE TABLE_NAME = '" + tableName + "' ";

                break;
        }
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            String colName = rs.getString(1);
            columnNames.add(colName);
        }
        rs.close();
        
        return columnNames;
    }

    public String getPrimaryKeyColumn(String tableName) throws SQLException {
        String primaryColumn = "";
        Connection connect = conn.getConnection();
        Statement stat = connect.createStatement();
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
                sqlString = "SELECT cols.table_name, cols.column_name, cols.position, cons.status, cons.owner "
                        + "FROM all_constraints cons, all_cons_columns cols "
                        + "WHERE cols.table_name = '" + tableName.toUpperCase() + "' "
                        + "AND cons.constraint_type = 'P' "
                        + "AND cons.constraint_name = cols.constraint_name "
                        + "AND cons.owner = cols.owner "
                        + "AND cons.owner = '" + DBConnection.DB_USER + "'"
                        + "ORDER BY cols.table_name, cols.position ";
                break;
            case "mssql":
                sqlString = "SELECT column_name as primarykeycolumn "
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
            primaryColumn += rs.getString(1) + " ";
        }
        rs.close();
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
    public LinkedList<Row> getAttributesForOneTable(String tableName, LinkedList<String> columnNames, String primaryColumn) throws SQLException {
        LinkedList<Row> liAttributes = new LinkedList<Row>();
        Connection connect = conn.getConnection();
        Statement stat = connect.createStatement();
        String sqlString = "SELECT * "
                + " FROM " + tableName + " ";
        ResultSet rs = stat.executeQuery(sqlString);
        int count = 0;
        String value = "";
        String pK = "";
        while (rs.next()) {
            for (int i = 0; i < columnNames.size(); i++) {
                String columnName = columnNames.get(i);              
                if (primaryColumn.trim().equals(columnName.trim())) {

                    switch (DatabaseConnectionDialogue.selectedDB) {
                        case "postgres":
                            pK = rs.getString(i + 1);
                            value += pK + ";";
                            break;
                        case "oracle":
                            pK = rs.getString(primaryColumn);
                            value += pK + ";";
                            break;
                        case "mssql":
                            pK = rs.getString(i+1);
                            value += pK + ";";
                            break;
                    }
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
        System.out.println(pK);
        rs.close();
        return liAttributes;
    }

}
