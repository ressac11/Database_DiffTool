/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
            liAllTables.add(new Table(tableName));
        }
        return liAllTables;
    }      
    
}
