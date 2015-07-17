/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import beans.NewColumns;
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

    private LinkedList<Integer> lis = new LinkedList<>();
    private LinkedList<Integer> list = new LinkedList<>();
    private LinkedList<Integer> lis1 = new LinkedList<>();
    private LinkedList<Integer> list2 = new LinkedList<>();
    private BLOperations bl = new BLOperations();
    public static LinkedList<Integer> newCols = new LinkedList<>();

    public void add() {
        lis.add(0);
        lis.add(3);
        list.add(2);
        list.add(5);
        lis1.add(1);
        lis1.add(2);
        list2.add(6);
        list2.add(7);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        Color c1 = new Color(145, 205, 167);
        Color c2 = new Color(0, 161, 93);

        if (value != null) {
            label = new JLabel(value.toString());
            label.setOpaque(true);
            label.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));
            label.setBackground(new Color(229, 229, 229));
            label.setForeground(Color.BLACK);
            add();
            if (newCols.contains(column)) {
                label.setBackground(c1);
            } else if (lis1.contains(row)) {
                label.setBackground(c2);
            }

        }
        return label;
    }

}
