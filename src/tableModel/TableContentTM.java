/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import beans.Row;
import gui.MainWindow;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Steffie
 */
public class TableContentTM extends AbstractTableModel {

    LinkedList<String> columns = new LinkedList<>();
    LinkedList<Row> rows = new LinkedList<>();

    public TableContentTM(LinkedList<String> column, LinkedList<Row> row) {
        this.columns = column;
        this.rows = row;
        fireTableRowsInserted(0, rows.size());
    }

    @Override
    public int getRowCount() {
        if (MainWindow.existingData) {
            if (rows.get(0).getValue().equals("")) {
                System.out.println("inNull");
                return 0;
            }
        }
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        String str = rows.get(rowIndex).getValue();
        System.out.println("in BL" + rows.size());
        System.out.println(rows.get(0).getValue());
        String[] strArray = str.split(";");

        return strArray[columnIndex];

    }

}
