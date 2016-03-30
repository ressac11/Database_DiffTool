package database;

import gui.DatabaseConnectionDialogue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    
    private static final int MAX_CONN = 100;
    private static int num_conn = 0;
    private static DBConnection theInstance = null;
    public static String DB_NAME;
    public static String DB_USER;
    public static String DB_PASSWD;
    public static String DB_URL;
    public static String DB_DRIVER;
    public static String DB_SID;
    public static Boolean newCon;

   /**
    * for creating an instance from the class DBConnectionPool
    * @return theInstace
    * @throws ClassNotFoundException 
    */
    public static DBConnection getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBConnection();
        }
        return theInstance;
    }

    private DBConnection() 
    {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) 
        {
        }
    }

    /**
     * creating a connection to the selected database
     * @return Connection
     */
    public synchronized Connection getConnection() {
  
        try {
            Connection conn = null;
            
            switch (DatabaseConnectionDialogue.selectedDB) {
                case "postgres":
                    conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);
                    break;
                case "oracle":
                    conn = DriverManager.getConnection(DB_URL + DB_SID, DB_USER, DB_PASSWD);
                    break;
                case "mssql":
                    String connectionUrl =  DB_URL + "databaseName=" + DB_NAME+";";
                    conn = DriverManager.getConnection(connectionUrl, DB_USER, DB_PASSWD);
                    break;
            }
            num_conn++;
            return conn;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;     
    }

   
}
