/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Steffie
 */
public class DifferentCell 
{
    private String tableName;
    private int columnIndex;
    private int rowIndex;
    private String value;

    public DifferentCell(String tableName, int columnIndex, int rowIndex, String value) {
        this.tableName = tableName;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.value = value;
    }
    
    

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "DifferentCell{" + "tableName=" + tableName + ", columnIndex=" + columnIndex + ", rowIndex=" + rowIndex + ", value=" + value + '}';
    }
    
    
}
