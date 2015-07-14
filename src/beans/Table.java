/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.LinkedList;

/**
 *
 * @author Sarah
 */
public class Table {
    private String tableName;
    private String rowCounter;
    private LinkedList<String> columnNames;
    private LinkedList<Row> attributes;

    public Table(String tableName, String rowCounter, LinkedList<String> columnNames, LinkedList<Row> attributes) {
        this.tableName = tableName;
        this.rowCounter = rowCounter;
        this.columnNames = columnNames;
        this.attributes = attributes;
    }

    public String getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(String rowCounter) {
        this.rowCounter = rowCounter;
    }
   
    public LinkedList<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(LinkedList<String> columnNames) {
        this.columnNames = columnNames;
    }

    public LinkedList<Row> getAttributes() {
        return attributes;
    }

    public void setAttributes(LinkedList<Row> attributes) {
        this.attributes = attributes;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    @Override
    public String toString() {
        return tableName;
    }
    
    
}
