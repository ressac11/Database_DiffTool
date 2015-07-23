package bl;

import beans.ColumnInformation;
import beans.NewColumns;
import beans.NewRow;
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

    private final String tableDelim = "#end#";
    private final String delim = "#";
    private String tableOfFirstDiff;
    private String[] strArray;
    private String tablename = "";
    private LinkedList<String> columns = new LinkedList<>();
    private int counter;
    private String rowCounter;
    private LinkedList<Table> allTables = new LinkedList<>();
    private LinkedList<NewColumns> allNewCols = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsLeft = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsRight = new LinkedList<>();
    private LinkedList<NewRow> allNewRowsRight = new LinkedList<>();
    private LinkedList<NewRow> allNewRowsLeft = new LinkedList<>();
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

        while ((tableOfFirstDiff = br.readLine()) != null) {
            if (tableOfFirstDiff.equals(dbName)) {
                countDBName = 1;
            } else {
                if (countDBName == 1) 
                {
                    databaseName = tableOfFirstDiff;
                    countDBName = 0;
                } 
                else 
                {
                    if (counter != -1) 
                    {
                        if (counter == 0) 
                        {
                            if (tableOfFirstDiff.equals("#end#")) 
                            {
                                counter = 0;
                            } else {
                                tablename = tableOfFirstDiff.split("#")[0];
                                rowCounter = tableOfFirstDiff.split("#")[1];
                                counter = 1;
                            }
                        } else if (counter == 1) {
                            strArray = tableOfFirstDiff.split("#");
                            for (int i = 0; i < strArray.length; i++) {
                                String str2 = strArray[i];
                                columns.add(str2);
                            }
                            counter++;
                        } else {
                            if (tableOfFirstDiff.equals("#end#") || tableOfFirstDiff.equals("endDatabase")) {
                                LinkedList<String> c2 = new LinkedList<>(columns);
                                LinkedList<Row> r2 = new LinkedList<>(liRows);
                                counter = 0;
                                Table t = new Table(tablename, rowCounter, c2, r2);
                                allTables.add(t);
                                columns.clear();
                                liRows.clear();
                                tablename = "";
                            } else {
                                Row r = new Row(counter, tableOfFirstDiff.split("#")[0]);
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
        allNewCols.clear();
        allNewRowsLeft.clear();
        allNewRowsRight.clear();
        LinkedList<Table> liAllTablesLeft = tablesLeft;
        LinkedList<Table> liAllTablesRight = tablesRight;
        int count = 0;
        for (int i = 0; i < liAllTablesLeft.size(); i++) {
            for (int j = 0; j < liAllTablesRight.size(); j++) {
                if (liAllTablesLeft.get(i).getTableName().equals(liAllTablesRight.get(j).getTableName())) {
                    count++;
                    compare(liAllTablesLeft.get(i), liAllTablesRight.get(j), companyNameLeft, companyNameRight);
                    allColsLeft.clear();
                    allColsRight.clear();
                }
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "The Tables can not be compared because non are equal");
        }
    }

    private void compare(Table tLeft, Table tRight, String companyNameLeft, String companyNameRight) {
        LinkedList<String> colLeft = tLeft.getColumnNames();
        LinkedList<String> colRight = tRight.getColumnNames();

        int sizeMax = colLeft.size();
        this.sizeMin = colRight.size();
        String companyName = companyNameLeft;
        String tablename = tLeft.getTableName();
        LinkedList<String> cols = (LinkedList<String>) colLeft.clone();
        if (colLeft.size() < colRight.size()) {
            sizeMax = colRight.size();
            this.sizeMin = colLeft.size();
            companyName = companyNameRight;
            tablename = tRight.getTableName();
            cols = (LinkedList<String>) colRight.clone();
        }
        for (int i = 0; i < sizeMax; i++) 
        {
            if (i < sizeMin) 
            {
                if (colLeft.contains(colRight.get(i))) 
                {
                    ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), i, colRight.get(i));
                    allColsRight.add(colinfoRight);
                    ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), colLeft.indexOf(colRight.get(i)), colLeft.get(colLeft.indexOf(colRight.get(i))));
                    allColsLeft.add(colinfoLeft);
                } else {
                    NewColumns newCol = new NewColumns(companyName, tablename, cols.get(i), i);
                    allNewCols.add(newCol);
                }
            } else 
            {
                for (int j = this.sizeMin; j < sizeMax; j++) 
                {
                    NewColumns newCol = new NewColumns(companyName, tablename, cols.get(j), j);
                    allNewCols.add(newCol);
                }
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
                NewRow row = new NewRow(companyNameRight, tRight.getTableName(), rR, valuesRight.get(rR));
                allNewRowsRight.add(row);
            }
        }
        //linke Liste durchgehen
        for (int rL = 0; rL < valuesLeft.size(); rL++) {
            if (!valuesRight.contains(valuesLeft.get(rL))) {
                NewRow row = new NewRow(companyNameLeft, tLeft.getTableName(), rL, valuesLeft.get(rL));
                allNewRowsLeft.add(row);
            }
        }
    }

    public void downloadComparisonOutput(File f) throws IOException 
    {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        String firstLine = "Results of Database Comparison: " + (+allNewCols.size() + allNewRowsLeft.size() + allNewRowsRight.size());
        bw.write(firstLine);
        bw.newLine();
        bw.newLine();
        String titleCol = String.format("Amount of new Columns: %d", allNewCols.size());
        bw.write(titleCol);
//        bw.newLine();
        Iterator<NewColumns> itCol = allNewCols.iterator();
        int countC = 1;

        while (itCol.hasNext()) 
        {
            NewColumns col = itCol.next();
            bw.write(col.getCompanyName());
            bw.newLine();
            bw.write(col.toString());
            bw.newLine();
            countC++;
        }
        Iterator<NewRow> itRowL = allNewRowsLeft.iterator();
        bw.newLine();
        String titleRow = String.format("Amount of different Rows in %s: %d", companyLeft, allNewRowsLeft.size());
        bw.write(titleRow);
        bw.newLine();
        while (itRowL.hasNext()) {
            NewRow row = itRowL.next();
            bw.write(row.toString());
            bw.newLine();
        }
        bw.newLine();
        bw.newLine();
        Iterator<NewRow> itRowR = allNewRowsRight.iterator();
        String titleRow2 = String.format("Amount of different Rows in %s: %d", companyRight, allNewRowsRight.size());
        bw.write(titleRow2);
        bw.newLine();
        while (itRowR.hasNext()) {
            NewRow row = itRowR.next();
            bw.write(row.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public boolean differenceExisting() 
    {
        tableOfFirstDiff = "";
        int count = 0;
        
        if (allNewCols.isEmpty()) 
        {
            count++;
        } 
        else 
        {
            tableOfFirstDiff = allNewCols.get(0).getTableName();
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
        allNewCols.clear();
        allNewRowsLeft.clear();
        allNewRowsRight.clear();
    }

    public LinkedList<NewColumns> getAllNewCols() {
        return allNewCols;
    }

    public LinkedList<NewRow> getAllNewRowsRight() {
        return allNewRowsRight;
    }

    public LinkedList<NewRow> getAllNewRowsLeft() {
        return allNewRowsLeft;
    }

    public String getStr() {
        return tableOfFirstDiff;
    }

    public String getDatabaseName() {
        return databaseName;
    }
    
    
}
