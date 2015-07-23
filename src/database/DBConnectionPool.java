package database;

import gui.DatabaseConnectionDialogue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnectionPool {

    private LinkedList<Connection> connections = new LinkedList();
    private static final int MAX_CONN = 100;
    private static int num_conn = 0;
    private static DBConnectionPool theInstance = null;
    public static String DB_NAME;
    public static String DB_USER;
    public static String DB_PASSWD;
    public static String DB_URL;
    public static String DB_DRIVER;

    public static DBConnectionPool getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBConnectionPool();
        }
        return theInstance;
    }

    private DBConnectionPool() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driverisfalsch");
        }
    }

    public synchronized Connection getConnection() {
        if (connections.isEmpty()) {
            try {
                if (num_conn == MAX_CONN) {

                }
                Connection conn = null;

                switch (DatabaseConnectionDialogue.selectedDB) {
                    case "postgres":
                        conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);
                        break;
                    case "oracle":
                        conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);
                        break;
                    case "mssql":
                        String connectionUrl = "jdbc:sqlserver://" + DB_URL + ":1433;databaseName=" + DB_NAME;
                        conn = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASSWD);
                        break;
                }
                num_conn++;
                return conn;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "There is no Connection possible");
                ex.printStackTrace();
            }
        } else {
            return connections.poll();
        }
        return null;
    }

    public synchronized void releaseConnection(Connection conn) {
        connections.offer(conn);
    }
}
