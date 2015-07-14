/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import beans.Row;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Steffie
 */
public class TableContentTM extends AbstractTableModel
{
    LinkedList<String> columns = new LinkedList<>();
    LinkedList<Row> rows = new LinkedList<>();

    public TableContentTM(LinkedList<String> column, LinkedList<Row> row) 
    {
        this.columns = column;
        this.rows = row;
    }
   
    @Override
    public int getRowCount() 
    {
        int count = 1;
        Row alt = rows.get(0);
        for (int i = 1; i < rows.size(); i++) 
        {
            Row neu = rows.get(i);
            if (neu.getRID() != alt.getRID()) 
            {
                alt = neu;
                count++;
            }
        }
        return count;
    }

    @Override
    public int getColumnCount() 
    {
        return columns.size();
    }

    @Override
    public String getColumnName(int column) 
    {
        return columns.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        String str = rows.get(rowIndex).getValue();
        String[] strArray = str.split(";");
        return strArray[columnIndex];
    }
    
    
}
