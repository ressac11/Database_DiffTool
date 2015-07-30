package renderer;

import beans.DifferentCell;
import beans.DifferentColumn;
import beans.DifferentRow;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableRenderer implements TableCellRenderer 
{
    public static LinkedList<DifferentColumn> newColsLeft = new LinkedList<>();
    public static LinkedList<DifferentColumn> newColsRight = new LinkedList<>();
    public static String selectedTable;
    public static LinkedList<DifferentRow> newRowLeft = new LinkedList<>();
    public static LinkedList<DifferentRow> newRowRight = new LinkedList<>();
    public static LinkedList<DifferentCell> newCellsLeft = new LinkedList<>();
    public static LinkedList<DifferentCell> newCellsRight = new LinkedList<>();

    /**
     * This method is responsible for colorfully highlighting different rows and different columns of two databases.
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return 
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        Color c1 = new Color(183, 34, 38);
        Color c2 = new Color(227, 103, 29);

        if (value != null) 
        {
            label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));
            label.setBackground(new Color(229, 229, 229));
            label.setForeground(Color.BLACK);
            
            if (table.getName().equals("tbTableContent1")) 
            {
                for (DifferentRow newRowLeft1 : newRowLeft) 
                {
                    if (newRowLeft1.getTableName().equals(selectedTable)) 
                    {
                        if (newRowLeft1.getRowIndex() == row) 
                        {
                            label.setBackground(c2);
                        }
                    }
                }
                for (DifferentColumn newCol : newColsLeft) 
                {
                    if (newCol.getTableName().equals(selectedTable) && newCol.getColumnIndex() == column) 
                    {
                            label.setBackground(c1);
                    }
                }
                for (DifferentCell cell : newCellsLeft) 
                {
                    if (cell.getTableName().equals(selectedTable) && cell.getColumnIndex() == column && cell.getRowIndex()== row) 
                    {
                            label.setBackground(c1);
                    }
                }
            } 
            else 
            {
                for (DifferentRow newRowRight1 : newRowRight) 
                {
                    if (newRowRight1.getTableName().equals(selectedTable)) 
                    {
                        if(newRowRight1.getRowIndex() == row )
                        {
                            label.setBackground(c2);
                        }
                    }
                }
                for (DifferentColumn newCol : newColsRight) 
                {
                    if (newCol.getTableName().equals(selectedTable) && newCol.getColumnIndex() == column) 
                    {
                            label.setBackground(c1);
                    }
                }
                for (DifferentCell cell : newCellsRight) 
                {
                    if (cell.getTableName().equals(selectedTable) && cell.getColumnIndex() == column && cell.getRowIndex()== row) 
                    {
                            label.setBackground(c1);
                    }
                }
            }
        }
        return label;
    }
}
