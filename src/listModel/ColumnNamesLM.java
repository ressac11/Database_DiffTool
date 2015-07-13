/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import beans.Row;
import database.DBAccess;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Sarah
 */
public class ColumnNamesLM extends AbstractListModel{

    private LinkedList<String> liColumn;

    public ColumnNamesLM(LinkedList<String> liColumns) {
        this.liColumn=liColumns;
    }

    @Override
    public int getSize() {
        return liColumn.size();
    }

    @Override
    public Object getElementAt(int index) {
        return liColumn.get(index);
    }
    
}
