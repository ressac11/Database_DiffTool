/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import beans.Row;
import beans.Table;
import database.DBAccess;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Sarah
 */
public class TableNamesLM extends AbstractListModel{

    private LinkedList<Table> liAllTables;

    public TableNamesLM(LinkedList<Table> allTables) throws ClassNotFoundException 
    {
        this.liAllTables=allTables;
    }
    
    @Override
    public int getSize() 
    {
        return liAllTables.size();
    }

    @Override
    public Object getElementAt(int index) 
    {
        return liAllTables.get(index);
    }

//    @Override
//    public String toString() 
//    {
//        
//        String s = "";
//        Table table = liAllTables.get(0);
//        for (String str : table.getColumnNames()) 
//        {
//            s = s.concat(String.format("%s   ", str));
//        }
//        s = s.concat("\n");
//        for (Row r : table.getAttributes()) 
//        {
//            s = s.concat(r.getValue()+"\n");
//
//        }
//
//        return s;
//    }
//    
//    
//    
}
