/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
    
    public void testConnection() throws Exception
    {
        int reID = 0;
        Connection conn = connPool.getConnection();
        Statement stat = conn.createStatement();
        String sqlString = "SELECT MAX(reservationid)"
                + "FROM reservation;";
        ResultSet rs = stat.executeQuery(sqlString);
        while (rs.next()) {
            reID = Integer.parseInt(rs.getString(1)) + 1;
        }
        connPool.releaseConnection(conn);
        System.out.println(reID);
    }
  
    
}
