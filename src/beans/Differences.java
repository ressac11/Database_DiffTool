/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Sarah
 */
public class Differences {
    private String companyName;
    private String tableName;
    private int columnIndex;
    private int rowIndex;
    private String value;

    public Differences(String companyName, String tableName, int columnIndex, int rowIndex, String value) {
        this.companyName = companyName;
        this.tableName = tableName;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.value = value;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
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
}
