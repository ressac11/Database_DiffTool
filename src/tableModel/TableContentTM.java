package tableModel;

import beans.Row;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

public class TableContentTM extends AbstractTableModel {

    LinkedList<String> columns = new LinkedList<>();
    LinkedList<Row> rows = new LinkedList<>();

    public TableContentTM(LinkedList<String> column, LinkedList<Row> row) {
        this.columns = column;
        this.rows = row;
    }

    @Override
    public int getRowCount() {
        try {
            return rows.size();
        } catch (Exception ex) {
            return 0;
        }
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
        try {
            String str = rows.get(rowIndex).getValue();
            String[] strArray = str.split(";");
            return strArray[columnIndex];
        } catch (Exception ex) {
            return "";
        }
    }
}
