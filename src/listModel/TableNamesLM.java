/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

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

    public TableNamesLM(LinkedList<Table> allTablesFirst) throws ClassNotFoundException {
        liAllTables=allTablesFirst;
    }
    
    @Override
    public int getSize() {
        return liAllTables.size();
    }

    @Override
    public Object getElementAt(int index) {
        return liAllTables.get(index);
    }
    
}
