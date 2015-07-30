/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listModel;

import beans.Table;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Sarah
 */
public class TableNamesLMD extends AbstractListModel {

    private LinkedList<String> liAllTables;

    public TableNamesLMD(LinkedList<String> allTables) throws ClassNotFoundException {
        this.liAllTables = allTables;
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

