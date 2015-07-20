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
public class TableRenderer implements TableCellRenderer {

    public static LinkedList<NewColumns> newCols = new LinkedList<>();
    public static String selectedTable;
    public static LinkedList<NewRow> newRowLeft = new LinkedList<NewRow>();
    public static LinkedList<NewRow> newRowRight = new LinkedList<NewRow>();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        Color c1 = new Color(183, 34, 38);
        Color c2 = new Color(227, 103, 29);

        if (value != null) {
            label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));
            label.setBackground(new Color(229, 229, 229));
            label.setForeground(Color.BLACK);
            if (table.getName().equals("tbTableContent1")) {
                for (int i = 0; i < newRowLeft.size(); i++) {
                    if(newRowLeft.get(i).getTableName().equals(selectedTable))
                    {
                    if (newRowLeft.get(i).getRowIndex() == row ) {
                        label.setBackground(c2);
                    }}
                }
            } else {
                for (int i = 0; i < newRowRight.size(); i++) {
                    if (newRowRight.get(i).getRowIndex() == row && newRowRight.get(i).getTableName().equals(selectedTable)) {
                        label.setBackground(c2);
                    }
                }
            }
            for (int i = 0; i < newCols.size(); i++) {
                if (newCols.get(i).getTableName().equals(selectedTable)) {
                    if (newCols.get(i).getColumnIndex() == column) {
                        label.setBackground(c1);
                    }
                }
            }
        }
        return label;
    }

}
