/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import beans.NewColumns;
import beans.NewRow;
import bl.BLOperations;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Sarah
 */
public class TableRenderer implements TableCellRenderer 
{
    public static LinkedList<NewColumns> newCols = new LinkedList<>();
    public static String selectedTable;
    public static LinkedList<NewRow> newRowLeft = new LinkedList<>();
    public static LinkedList<NewRow> newRowRight = new LinkedList<>();

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
                
                for (NewRow newRowLeft1 : newRowLeft) 
                {
                    if (newRowLeft1.getTableName().equals(selectedTable)) 
                    {
                        System.out.println(newRowLeft1.getTableName());
                        System.out.println(newRowLeft1.getRowIndex());
                        if (newRowLeft1.getRowIndex() == row) 
                        {
                            label.setBackground(c2);
                        }
                    }
                }
            } 
            else 
            {
                for (NewRow newRowRight1 : newRowRight) 
                {
                    if (newRowRight1.getTableName().equals(selectedTable)) 
                    {
                        if(newRowRight1.getRowIndex() == row )
                        {
                            label.setBackground(c2);
                        }
                    }
                }
            }
            for (NewColumns newCol : newCols) 
            {
                if (newCol.getTableName().equals(selectedTable) && newCol.getColumnIndex() == column) 
                {
                        label.setBackground(c1);
                }
            }
        }
        return label;
    }

}
