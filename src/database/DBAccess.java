/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;

/**
 *
 * @author Sarah
 */
public class DBAccess {
    private Connection con;
    private static DBAccess theInstance = null;
    private DBConfig dbc = new DBConfig();
    
    public static DBAccess getTheInstance() throws ClassNotFoundException {
        if (theInstance == null) {
            theInstance = new DBAccess();
        }
        return theInstance;
    }

    public void createConnection(String User, String Password, String Driver, String Database, String Database_Name, String URL) throws Exception
    {
        con = dbc.getConnection(User, Password, Driver, Database, Database_Name, URL);
    }

    
}
