/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import gui.DatabaseConnectionDialogue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;

/**
 *
 * @author Sarah
 */
public class DBConnectionPool {
    
    private LinkedList<Connection> connections = new LinkedList<>();
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

    private DBConnectionPool() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
    }

    public synchronized Connection getConnection() throws Exception {
        if (connections.isEmpty()) {

            if (num_conn == MAX_CONN) {
                throw new Exception("Maximum number of connections reached");
            }
            Connection conn=null;
            switch(DatabaseConnectionDialogue.selectedDB)
            {
                case "postgres": conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);break;
                case "oracle": conn=DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWD);break;
                case "mssql": conn=DriverManager.getConnection(DB_URL+"databaseName="+DB_NAME+";user="+DB_USER+";password="+DB_PASSWD);break;                
            }          
            num_conn++;
            return conn;
        } else {
            return connections.poll();
        }
    }
    
    public synchronized void releaseConnection(Connection conn) {
        connections.offer(conn);
    }   
    
}
