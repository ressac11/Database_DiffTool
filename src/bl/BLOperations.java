/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;
import beans.ColumnInformation;
import beans.Differences;
import beans.NewColumns;
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
/**
 *
 * @author Sarah
 */
public class BLOperations 
{
    private final String tableDelim = "#end#";
    private final String delim = "#";
    private String str;
    private String[] strArray;
    private String tablename = "";
    private LinkedList<String> columns = new LinkedList<>();
    private int counter;
    private String rowCounter;
    private LinkedList<Table> allTables = new LinkedList<>();
    private LinkedList<NewColumns> allNewCols = new LinkedList<>();
    private LinkedList<Differences> allDiffs = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsLeft = new LinkedList<>();
    private LinkedList<ColumnInformation> allColsRight = new LinkedList<>();

    public LinkedList<Table> loadData(File f) throws FileNotFoundException, IOException 
    {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        counter = -1;
        allTables.clear();
        tablename = "";
        LinkedList<Row> liRows = new LinkedList<>();
        while ((str = br.readLine()) != null) {
            if (counter != -1) {
                if (counter == 0) {
                    if (str.equals("#end#")) {
                        counter = 0;
                    } else {
                        tablename = str.split("#")[0];
                        rowCounter=str.split("#")[1];
                        counter=1;
                    }
                } else if (counter == 1) {
                    strArray = str.split("#");
                    for (int i = 0; i < strArray.length; i++) {
                        String str2 = strArray[i];
                        columns.add(str2);
                        System.out.println(str2 + " ");
                    }
                    counter++;
                } else {
                    if (str.equals("#end#") || str.equals("endDatabase")) {
                        LinkedList<String> c2 = new LinkedList<>(columns);  
                        LinkedList<Row> r2 = new LinkedList<>(liRows);
                        counter = 0;
                        Table t = new Table(tablename, rowCounter, c2, r2);
                        allTables.add(t);                       
                        columns.clear();
                        liRows.clear();
                        tablename="";                       
                    } else {
                        Row r = new Row(counter, str.split("#")[0]);
                        liRows.add(r);
                    }
                }
            } else {
                counter++;
            }
        }
        br.close();
        return allTables;
    }
    
    public void saveDatabaseFile(File f, LinkedList<Table> tables, String DatabaseName) throws IOException 
    {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = tables.iterator();

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
            for (String column : columns) 
            {
                bw.write(column + delim);
                c++;
                if (c == columns.size()) 
                {
                    bw.newLine();
                }
            }

            List<Row> rows = table.getAttributes();
            Row oldValue = rows.get(0);
            bw.write(oldValue.getValue() + delim);

            for (int i = 1; i < rows.size(); i++)
            {
                Row r2 = rows.get(i);
                if (r2.getRID() != oldValue.getRID()) 
                {
                    bw.newLine();
                    oldValue = r2;
                }
                bw.write(r2.getValue() + delim);
            }
        }
        bw.newLine();
        bw.write("endDatabase");
        bw.flush();
        bw.close();
    }
    
    public void compareDatabases(String companyNameLeft, String companyNameRight, LinkedList<Table> tablesLeft, LinkedList<Table> tablesRight)
    {
        LinkedList<Table> liAllTablesLeft = tablesLeft;
        LinkedList<Table> liAllTablesRight = tablesRight;
        int count = 0;
        for (int i = 0; i < liAllTablesLeft.size(); i++) 
        {
            for (int j = 0; j < liAllTablesRight.size(); j++) 
            {
                if (liAllTablesLeft.get(i).getTableName().equals(liAllTablesRight.get(j).getTableName())) 
                {
                    count++;
                    System.out.println("Tables are equal: ");
                    System.out.println("Table left: "+liAllTablesLeft.get(i).getTableName());
                    System.out.println("Table right: "+liAllTablesRight.get(j).getTableName());
                    System.out.println("");
                    compare(liAllTablesLeft.get(i), liAllTablesRight.get(j),companyNameLeft, companyNameRight);
                }
            }
        }
        if(count == 0)
        {
            JOptionPane.showMessageDialog(null, "The Tables can not be compared because non are equal");
        }
    }
    
    private void compare(Table tLeft, Table tRight, String companyNameLeft, String companyNameRight)
    {
        LinkedList<String> colLeft = tLeft.getColumnNames();
        LinkedList<String> colRight = tRight.getColumnNames();
//        if(colLeft.size() == colLeft.size())
//        {
//            
//        }
        //alle Spalten beider Tabellen auf Listen speichern, alle neuen Spalten einer Tabelle auf separate Liste speichern
        for (int i = 0; i < colLeft.size(); i++) 
        {
            if(colLeft.contains(colRight.get(i)))
            {
                ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), i, colRight.get(i));
                allColsRight.add(colinfoRight);
                System.out.println("Col Info Left: "+colinfoRight.toString());
                ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), colLeft.indexOf(colRight.get(i)), colLeft.get(colLeft.indexOf(colRight.get(i))));
                allColsLeft.add(colinfoLeft);
                System.out.println("Col Info Right: "+colinfoLeft.toString());
            }
            else
            {
                NewColumns newCol = new NewColumns(companyNameRight, tRight.getTableName(), colRight.get(i), i);
                allNewCols.add(newCol);
                System.out.println("New Cols: "+newCol.toString());
            }
        }
        
        LinkedList<Row> valuesLeft = tLeft.getAttributes();
        LinkedList<Row> valuesRight = tRight.getAttributes();
        
        int size = valuesLeft.size();
        if(valuesLeft.size() > valuesRight.size())
        {
            size = valuesRight.size();
        }
        System.out.println("row size for comparing: "+size);
        //Inhalte jeder Zelle der Tabellen vergleichen
        for (int r = 0; r < size; r++) 
        {
            Row rLeft = valuesLeft.get(r);
            Row rRight = valuesRight.get(r);
            System.out.println("Row Left: "+rLeft.toString());
            System.out.println("Row Right: "+rRight.toString());
            
            for (int i = 0; i < allColsLeft.size(); i++)
            {
                System.out.println("all cols left size: "+allColsLeft.size());
                System.out.println("all cols right size: "+allColsRight.size());
                int indexLeft = allColsLeft.get(i).getColumnIndex();
                int indexRigt = allColsRight.get(i).getColumnIndex();
                System.out.println("index of act left column: "+indexLeft);
                System.out.println("index of akt right column: "+indexRigt);
                
                String[] strLeft = rLeft.getValue().split(";");
                String[] strRight = rRight.getValue().split(";");
                System.out.println("value of index left col: "+strLeft[indexLeft]);
                System.out.println("value of index right col: "+strRight[indexRigt]);
                
                if(!strLeft[indexLeft].equals(strRight[indexRigt]))
                {
                    Differences diffLeft = new Differences(companyNameLeft, tLeft.getTableName(), indexLeft, rLeft.getRID(), rLeft.getValue().split(";")[indexLeft]);
                    Differences diffRight = new Differences(companyNameRight, tRight.getTableName(), indexRigt, rRight.getRID(), rLeft.getValue().split(";")[indexRigt]);
                    allDiffs.add(diffLeft);
                    allDiffs.add(diffRight);
                }
                
            }
        }
    }
    
    public void comparisonOutput()
    {
        System.out.println("All new Columns: ");
        for (NewColumns newCol : allNewCols) 
        {
            System.out.println(newCol.toString());
        }
        System.out.println("");
        System.out.println("All Differences: ");
        for (Differences diff : allDiffs) 
        {
            System.out.println(diff.toString());
        }
    }

}
