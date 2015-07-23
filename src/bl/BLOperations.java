package bl;

import beans.ColumnInformation;
import beans.DifferentColumn;
import beans.DifferentRow;
import beans.Row;
import beans.Table;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class BLOperations {

    private final String dbDelim =    "#++++++++++++++++++++++++++++++++++++++++++++++++++#";
    private final String tableDelim = "#----------------------------------------------------------#";
    private final String delim = "#";
    private String tableOfFirstDiff;
    private String[] strArray;
    private String tablename = "";
    private LinkedList<String> columns = new LinkedList<>();
    private int counter;
    private String rowCounter;
    private LinkedList<Table> allTables = new LinkedList<>();
    private LinkedList<DifferentColumn> allNewColsLeft = new LinkedList<>();
    private LinkedList<DifferentColumn> allNewColsRight = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsLeft = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsRight = new LinkedList<>();
    private LinkedList<DifferentRow> allNewRowsRight = new LinkedList<>();
    private LinkedList<DifferentRow> allNewRowsLeft = new LinkedList<>();
    private int sizeMin;
    private String companyLeft = "";
    private String companyRight = "";
    private String dbName = "#dbname#";
    private String databaseName = "";

    public LinkedList<Table> loadData(File f) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        counter = -1;
        allTables.clear();
        tablename = "";
        LinkedList<Row> liRows = new LinkedList<>();
        columns.clear();
        liRows.clear();
        int countDBName = 0;
        String str = "";

        while ((str = br.readLine()) != null) 
        {
            if (str.equals(dbName)) 
            {
                countDBName = 1;
            } 
            else 
            {
                if (countDBName == 1) 
                {
                    databaseName = str;
                    countDBName = 0;
                } 
                else 
                {
                    if (counter != -1) 
                    {
                        if (counter == 0) 
                        {
                            if (str.equals(tableDelim)) 
                            {
                                counter = 0;
                            } else {
                                tablename = str.split("#")[0];
                                rowCounter = str.split("#")[1];
                                counter = 1;
                            }
                        } else if (counter == 1) {
                            strArray = str.split("#");
                            for (int i = 0; i < strArray.length; i++) {
                                String str2 = strArray[i];
                                columns.add(str2);
                            }
                            counter++;
                        } else {
                            
                            if (str.equals(tableDelim) || str.equals("endDatabase")) {
                                LinkedList<String> c2 = new LinkedList<>(columns);
                                LinkedList<Row> r2 = new LinkedList<>(liRows);
                                counter = 0;
                                Table t = new Table(tablename, rowCounter, c2, r2);
                                allTables.add(t);
                                columns.clear();
                                liRows.clear();
                                tablename = "";
                            } else {
                                
                                Row r = new Row(counter, str.split("#")[0]);
                                liRows.add(r);
                                
                            }
                        
                    }
                    }
                    else 
                    {
                        counter++;
                    }
                }
            }
        }
        br.close();
        return allTables;
    }

    public void saveDatabaseFile(File f, LinkedList<Table> tables, String DatabaseName) throws IOException {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = tables.iterator();
        bw.write(dbName);
        bw.newLine();
        bw.write(DatabaseName);
        bw.newLine();
        while (it.hasNext()) 
        {
            Table table = it.next();
            bw.newLine();
            bw.write(tableDelim);
            bw.newLine();
            bw.write(table.getTableName());
            bw.write(delim);
            bw.write(table.getRowCounter());
            bw.newLine();
            List<String> columns = table.getColumnNames();
            int c = 0;
            for (String column : columns) {
                bw.write(column + delim);
                c++;
                if (c == columns.size()) {
                    bw.newLine();
                }
            }

            List<Row> rows = table.getAttributes();
            if (rows.size() > 0) {
                Row oldValue = rows.get(0);
                bw.write(oldValue.getValue() + delim);

                for (int i = 1; i < rows.size(); i++) {
                    Row r2 = rows.get(i);
                    if (r2.getRID() != oldValue.getRID()) {
                        bw.newLine();
                        oldValue = r2;
                    }
                    bw.write(r2.getValue() + delim);
                }
            }
        }
        bw.newLine();
        bw.write("endDatabase");
        bw.flush();
        bw.close();
    }

    public void compareDatabases(String companyNameLeft, String companyNameRight, LinkedList<Table> tablesLeft, LinkedList<Table> tablesRight) {
        companyLeft = companyNameLeft;
        companyRight = companyNameRight;
        allColsLeft.clear();
        allColsRight.clear();
        allNewColsLeft.clear();
        allNewColsRight.clear();
        allNewRowsLeft.clear();
        allNewRowsRight.clear();
        LinkedList<Table> liAllTablesLeft = tablesLeft;
        LinkedList<Table> liAllTablesRight = tablesRight;
        int count = 0;
        for (int i = 0; i < liAllTablesLeft.size(); i++) {
            for (int j = 0; j < liAllTablesRight.size(); j++) {
                if (liAllTablesLeft.get(i).getTableName().equals(liAllTablesRight.get(j).getTableName())) {
                    count++;
                    compare(liAllTablesLeft.get(i), liAllTablesRight.get(j));
                    allColsLeft.clear();
                    allColsRight.clear();
                }
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "The Tables can not be compared because non are equal");
        }
    }

    private void compare(Table tLeft, Table tRight) {
        LinkedList<String> colLeft = tLeft.getColumnNames();
        LinkedList<String> colRight = tRight.getColumnNames();

        for (int i = 0; i < colRight.size(); i++) 
        {
                if (colLeft.contains(colRight.get(i))) 
                {
                    ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), i, colRight.get(i));
                    allColsRight.add(colinfoRight);
                    ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), colLeft.indexOf(colRight.get(i)), colLeft.get(colLeft.indexOf(colRight.get(i))));
                    allColsLeft.add(colinfoLeft);
                } 
                else 
                {
                    DifferentColumn newColR = new DifferentColumn(tRight.getTableName(), colRight.get(i), i);
                    allNewColsRight.add(newColR);
                }
        }
        for (int i = 0; i < colLeft.size(); i++) 
        {
                if (colRight.contains(colLeft.get(i))) 
                {
                    ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), colRight.indexOf(colLeft.get(i)), colRight.get(colRight.indexOf(colLeft.get(i))));
                    allColsRight.add(colinfoRight);
                    ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), i, colLeft.get(i));
                    allColsLeft.add(colinfoLeft);
                } 
                else 
                {
                    DifferentColumn newColL = new DifferentColumn(tLeft.getTableName(), colLeft.get(i), i);
                    allNewColsLeft.add(newColL);
                }
        }
        

        LinkedList<Row> leftV = tLeft.getAttributes();
        LinkedList<Row> rightV = tRight.getAttributes();
        LinkedList<String> valuesRight = new LinkedList<>();
        LinkedList<String> valuesLeft = new LinkedList<>();
        for (Row r : rightV) {
            valuesRight.add(r.getValue());
        }
        for (Row r : leftV) {
            valuesLeft.add(r.getValue());
        }
        //rechte Liste durchgehen
        for (int rR = 0; rR < valuesRight.size(); rR++) {
            if (!valuesLeft.contains(valuesRight.get(rR))) {
                DifferentRow row = new DifferentRow(tRight.getTableName(), valuesRight.get(rR), rR);
                allNewRowsRight.add(row);
            }
        }
        //linke Liste durchgehen
        for (int rL = 0; rL < valuesLeft.size(); rL++) {
            if (!valuesRight.contains(valuesLeft.get(rL))) {
                DifferentRow row = new DifferentRow(tLeft.getTableName(), valuesLeft.get(rL), rL);
                allNewRowsLeft.add(row);
            }
        }
    }

    public void downloadComparisonOutput(File f) throws IOException 
    {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        String firstLine = "Results of Database Comparison: " + (+allNewColsLeft.size() + allNewColsRight.size() + allNewRowsLeft.size() + allNewRowsRight.size());
        bw.write(firstLine);
        bw.newLine();
        bw.newLine();
        String titleCol1 = String.format("Amount of different Columns in %s: %d", companyLeft, allNewColsLeft.size());
        bw.write(titleCol1);
        bw.newLine();
        Iterator<DifferentColumn> itCol = allNewColsLeft.iterator();

        while (itCol.hasNext()) 
        {
            DifferentColumn col = itCol.next();
            bw.newLine();
            bw.write(col.toString());
            bw.newLine();
        }
        bw.newLine();
        bw.newLine();
        bw.write(tableDelim);
        bw.newLine();
        bw.newLine();
        String titleCol2 = String.format("Amount of different Columns in %s: %d", companyRight, allNewColsRight.size());
        bw.write(titleCol2);
        bw.newLine();
        Iterator<DifferentColumn> itCol2 = allNewColsRight.iterator();

        while (itCol2.hasNext()) 
        {
            DifferentColumn col = itCol2.next();
            bw.newLine();
            bw.write(col.toString());
            bw.newLine();
        }
        
        Iterator<DifferentRow> itRowL = allNewRowsLeft.iterator();
        bw.newLine();
        bw.newLine();
        bw.write(dbDelim);
        bw.newLine();
        bw.newLine();
        String titleRow = String.format("Amount of different Rows in %s: %d", companyLeft, allNewRowsLeft.size());
        bw.write(titleRow);
        bw.newLine();
        bw.newLine();
        String curTableName = itRowL.next().getTableName();
        bw.write(curTableName);
        bw.newLine();
        while (itRowL.hasNext()) 
        {
            DifferentRow row = itRowL.next();
            if(curTableName.equals(row.getTableName()))
            {
                bw.write(row.getValue());
                bw.newLine();
            }
            else
            {
                curTableName = row.getTableName();
                bw.newLine();
                bw.write(tableDelim);
                bw.newLine();
                bw.newLine();
                bw.write(curTableName);
                bw.newLine();
                bw.write(row.getValue());
                bw.newLine();
            }
        }
        bw.newLine();
        bw.newLine();
        bw.write(dbDelim);
        bw.newLine();
        bw.newLine();
        Iterator<DifferentRow> itRowR = allNewRowsRight.iterator();
        String titleRow2 = String.format("Amount of different Rows in %s: %d", companyRight, allNewRowsRight.size());
        bw.write(titleRow2);
        bw.newLine();
        bw.newLine();
        curTableName = itRowR.next().getTableName();
        bw.write(curTableName);
        bw.newLine();
        while (itRowR.hasNext()) 
        {
            DifferentRow row = itRowR.next();
            if(curTableName.equals(row.getTableName()))
            {
                bw.write(row.getValue());
                bw.newLine();
            }
            else
            {
                curTableName = row.getTableName();
                bw.newLine();
                bw.write(tableDelim);
                bw.newLine();
                bw.newLine();
                bw.write(curTableName);
                bw.newLine();
                bw.write(row.getValue());
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    
    public boolean differenceExisting() 
    {
        tableOfFirstDiff = "";
        int count = 0;
        
        if (allNewColsLeft.isEmpty()) 
        {
            count++;
        } 
        else 
        {
            tableOfFirstDiff = allNewColsLeft.get(0).getTableName();
        }
        if (allNewColsRight.isEmpty()) 
        {
            count++;
        } 
        else 
        {
            tableOfFirstDiff = allNewColsRight.get(0).getTableName();
        }

        if (allNewRowsLeft.isEmpty()) 
        {
            count++;
        } 
        else 
        {
            tableOfFirstDiff = allNewRowsLeft.get(0).getTableName();
        } 
        if (allNewRowsRight.isEmpty()) 
        {
            count++;
        } 
        else 
        {
            tableOfFirstDiff = allNewRowsRight.get(0).getTableName();
        }
        if (count == 3) 
        {
            JOptionPane.showMessageDialog(null, "the databases are completely equal");
        } 
        else 
        {
            return true;
        }
        return false;
    }
    
    public LinkedList<Table> getEqualTables(LinkedList<Table> tablesLeft, LinkedList<Table> tablesRight)
    {
        LinkedList<Table> liAllEqualTables = new LinkedList<>();
        for (Table tL : tablesLeft) 
        {
            for (Table tR : tablesRight) 
            {
                if (tL.getTableName().equals(tR.getTableName())) 
                {
                    liAllEqualTables.add(tL);
                }
            }
        }
        return liAllEqualTables;
    }
    
    public void clearCompareOutputLists()
    {
        allNewColsLeft.clear();
        allNewColsRight.clear();
        allNewRowsLeft.clear();
        allNewRowsRight.clear();
    }

    public LinkedList<DifferentColumn> getAllNewColsLeft() {
        return allNewColsLeft;
    }
    
    public LinkedList<DifferentColumn> getAllNewColsRight() {
        return allNewColsRight;
    }

    public LinkedList<DifferentRow> getAllNewRowsRight() {
        return allNewRowsRight;
    }

    public LinkedList<DifferentRow> getAllNewRowsLeft() {
        return allNewRowsLeft;
    }

    public String getTableofFirstDiff() {
        return tableOfFirstDiff;
    }

    public String getDatabaseName() {
        return databaseName;
    }
    
    
}
