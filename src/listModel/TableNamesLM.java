package listModel;

import beans.Table;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

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
}
