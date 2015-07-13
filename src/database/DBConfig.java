/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Steffie
 */
public class DBConfig 
{
    
    public DBConfig() 
    {
        
    }
    
    public void createDBDump(String User, String Password, String Driver, String Database, String Database_Name, String URL) throws Exception //muss synchronized sein um Fehler zu vermeiden -> ganz wichtig !!!
    {
        Class.forName(Driver);
        Connection conn = DriverManager.getConnection(URL+Database_Name, User, Password);
    }
    
}
