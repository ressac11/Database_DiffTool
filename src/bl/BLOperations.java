package bl;

import beans.ColumnInformation;
import beans.DifferentCell;
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
import org.apache.commons.io.FileUtils;

public class BLOperations {

    private final String dbDelim = "#++++++++++++++++++++++++++++++++++++++++++++++++++#";
    private final String tableDelim = "#----------------------------------------------------------#";
    private final String delim = "#";
    private final String pkDelim = "--";
    private String tableOfFirstDiff;
    private String[] strArray;
    private String tablename = "";
    private final LinkedList<String> columns = new LinkedList<>();
    private int counter;
    private final LinkedList<Table> allTables = new LinkedList<>();
    private final LinkedList<DifferentColumn> allNewColsLeft = new LinkedList<>();
    private final LinkedList<DifferentColumn> allNewColsRight = new LinkedList<>();
    private final LinkedList<ColumnInformation> allColsLeft = new LinkedList<>();
    private final LinkedList<ColumnInformation> allColsRight = new LinkedList<>();
    private final LinkedList<DifferentRow> allNewRowsRight = new LinkedList<>();
    private final LinkedList<DifferentRow> allNewRowsLeft = new LinkedList<>();
    private final LinkedList<DifferentCell> allNewCellsRight = new LinkedList<>();
    private final LinkedList<DifferentCell> allNewCellsLeft = new LinkedList<>();
    private String companyLeft = "";
    private String companyRight = "";
    private final String dbName = "#dbname#";
    private String databaseName = "";

    /**
     * In this method the database data stored in a .txt file is loaded into the
     * program and stored in the classes Row and Table.
     *
     * @param f
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
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
        String str;

        while ((str = br.readLine()) != null) {
            if (str.equals(dbName)) {
                countDBName = 1;
            } else {
                if (countDBName == 1) {
                    databaseName = str;
                    countDBName = 0;
                } else {
                    if (counter != -1) {
                        if (counter == 0) {
                            if (str.equals(tableDelim)) {
                                counter = 0;
                            } else {
                                tablename = str.split("#")[0];
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
                                Table t = new Table(tablename, c2, r2);
                                allTables.add(t);
                                columns.clear();
                                liRows.clear();
                                tablename = "";
                            } else {
                                if (!str.equals("")) {
                                    Row r = new Row(counter, str.split(delim)[0].split(pkDelim)[0], str.split(delim)[0].split(pkDelim)[1]);
                                    liRows.add(r);
                                }
                            }
                        }
                    } else {
                        counter++;
                    }
                }
            }
        }
        br.close();
        return allTables;
    }

    /**
     * Optionally the new created file including the entire database data can be
     * saved in a .txt file. This saving process happens here.
     *
     * @param f
     * @param tables
     * @param DatabaseName
     * @throws IOException
     */
    public void saveDatabaseFile(File f, LinkedList<Table> tables, String DatabaseName) throws IOException {
        File file = f;
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Iterator<Table> it = tables.iterator();
        bw.write(dbName);
        bw.newLine();
        bw.write(DatabaseName);
        bw.newLine();
        while (it.hasNext()) {
            Table table = it.next();
            bw.newLine();
            bw.write(tableDelim);
            bw.newLine();
            bw.write(table.getTableName());
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
                bw.write(oldValue.getValue() + pkDelim + oldValue.getPrimaryKey() + delim);

                for (int i = 1; i < rows.size(); i++) {
                    Row r2 = rows.get(i);
                    if (r2.getRID() != oldValue.getRID()) {
                        bw.newLine();
                        oldValue = r2;
                    }
                    bw.write(r2.getValue() + pkDelim + r2.getPrimaryKey() + delim);
                }
            }
        }
        bw.newLine();
        bw.write("endDatabase");
        bw.flush();
        bw.close();
    }

    /**
     * In this method the tables of both databases are compared to equality, if
     * so, they are passed on to the actual comparing method.
     *
     * @param companyNameLeft
     * @param companyNameRight
     * @param tablesLeft
     * @param tablesRight
     */
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
        for (Table lT : liAllTablesLeft) {
            for (Table rT : liAllTablesRight) {
                if (lT.getTableName().equals(rT.getTableName())) {
                    count++;
                    compare(lT, rT);
                    allColsLeft.clear();
                    allColsRight.clear();
                }
            }
        }
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "The tables can not be compared because non are equal");
        }
    }

    /**
     * This method is responsible for the actual comparing process of two
     * particular tables.
     *
     * @param tLeft
     * @param tRight
     */
    private void compare(Table tLeft, Table tRight) {
        LinkedList<String> colLeft = tLeft.getColumnNames();
        LinkedList<String> colRight = tRight.getColumnNames();

        for (int i = 0; i < colRight.size(); i++) {
            if (colLeft.contains(colRight.get(i))) {
                ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), i, colRight.get(i));
                allColsRight.add(colinfoRight);
                ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), colLeft.indexOf(colRight.get(i)), colLeft.get(colLeft.indexOf(colRight.get(i))));
                allColsLeft.add(colinfoLeft);
            } else {
                DifferentColumn newColR = new DifferentColumn(tRight.getTableName(), colRight.get(i), i);
                allNewColsRight.add(newColR);
            }
        }
        for (int i = 0; i < colLeft.size(); i++) {
            if (colRight.contains(colLeft.get(i))) {
                ColumnInformation colinfoRight = new ColumnInformation(tRight.getTableName(), colRight.indexOf(colLeft.get(i)), colRight.get(colRight.indexOf(colLeft.get(i))));
                allColsRight.add(colinfoRight);
                ColumnInformation colinfoLeft = new ColumnInformation(tLeft.getTableName(), i, colLeft.get(i));
                allColsLeft.add(colinfoLeft);
            } else {
                DifferentColumn newColL = new DifferentColumn(tLeft.getTableName(), colLeft.get(i), i);
                allNewColsLeft.add(newColL);
            }
        }
        LinkedList<Row> leftV = tLeft.getAttributes();
        LinkedList<Row> rightV = tRight.getAttributes();
        LinkedList<String> valuesRight = new LinkedList<>();
        LinkedList<String> valuesLeft = new LinkedList<>();
        String valueTemp = "";
        int counter = 0;
        boolean outOfFor = false;

        for (Row r : rightV) {
            for (DifferentColumn col : allNewColsRight) {
                if (tRight.getTableName().equals(col.getTableName())) {
                    for (String str : r.getValue().split(";")) {
                        if (counter != col.getColumnIndex()) {
                            valueTemp += str + ";";
                        }
                        counter++;
                    }
                    valuesRight.add(valueTemp);
                } else {
                    break;
                }
            }
            valuesRight.add(r.getValue());
            counter = 0;
            valueTemp = "";
        }
        counter = 0;
        valueTemp = "";
        for (Row r : leftV) {
            for (DifferentColumn col : allNewColsLeft) {
                if (tLeft.getTableName().equals(col.getTableName())) {
                    for (String str : r.getValue().split(";")) {
                        if (counter != col.getColumnIndex()) {
                            valueTemp += str + ";";
                        }
                        counter++;
                    }
                    valuesLeft.add(valueTemp);
                } else {
                    break;
                }
            }
            valuesLeft.add(r.getValue());
            counter = 0;
            valueTemp = "";
        }
        //rechte Liste durchgehen
        counter = 0;
        String[] arrayR = null;
        System.out.println("starting with cells right");
        int tempSize = valuesLeft.size();
        if (valuesLeft.size() > valuesRight.size()) {
            tempSize = valuesRight.size();
        }
        for (int rL = 0; rL < tempSize; rL++) {
            arrayR = valuesRight.get(rL).split(";");
            for (String arrayL : valuesLeft.get(rL).split(";")) {
                if (!arrayL.equals(arrayR[rL])) {
                    DifferentCell diffCellL = new DifferentCell(tLeft.getTableName(), counter, rL, arrayL);
                    diffCellL.toString();
                    allNewCellsLeft.add(diffCellL);
                }
                counter++;
            }
            counter = 0;
        }
        String[] strL = null;
        counter = 0;
        System.out.println("starting with cells left");
        for (int rR = 0; rR < tempSize; rR++) {
            strL = valuesLeft.get(rR).split(";");
            for (String strR : valuesRight.get(rR).split(";")) {
                if (!strR.equals(strL[rR])) {
                    DifferentCell diffCellR = new DifferentCell(tRight.getTableName(), counter, rR, strR);
                    diffCellR.toString();
                    allNewCellsRight.add(diffCellR);
                }
                counter++;
            }
            counter = 0;
        }
//            if (!valuesLeft.contains(valuesRight.get(rR))) 
//            {
//                DifferentRow row = new DifferentRow(tRight.getTableName(), valuesRight.get(rR), rR);
//                allNewRowsRight.add(row);
//            }
//        //linke Liste durchgehen
//        for (int rL = 0; rL < valuesLeft.size(); rL++) {
//            if (!valuesRight.contains(valuesLeft.get(rL))) {
//                DifferentRow row = new DifferentRow(tLeft.getTableName(), valuesLeft.get(rL), rL);
//                allNewRowsLeft.add(row);
//            }
//        }
    }

    /**
     * In this method the output of the comparison process is written onto a
     * .txt file.
     *
     * @param f
     * @throws IOException
     */
    public void downloadComparisonOutput(File f) throws IOException {
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

        while (itCol.hasNext()) {
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

        while (itCol2.hasNext()) {
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
        while (itRowL.hasNext()) {
            DifferentRow row = itRowL.next();
            if (curTableName.equals(row.getTableName())) {
                bw.write(row.getValue());
                bw.newLine();
            } else {
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
        while (itRowR.hasNext()) {
            DifferentRow row = itRowR.next();
            if (curTableName.equals(row.getTableName())) {
                bw.write(row.getValue());
                bw.newLine();
            } else {
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

    /**
     * This method ensures whether there are any differences between those
     * databases found and returns true if so. This method is needed to know
     * whether to enable the download function.
     *
     * @return
     */
    public boolean differenceExisting() {
        tableOfFirstDiff = "";
        int count = 0;

        if (allNewColsLeft.isEmpty()) {
            count++;
        } else {
            tableOfFirstDiff = allNewColsLeft.get(0).getTableName();
        }
        if (allNewColsRight.isEmpty()) {
            count++;
        } else {
            tableOfFirstDiff = allNewColsRight.get(0).getTableName();
        }

        if (allNewRowsLeft.isEmpty()) {
            count++;
        } else {
            tableOfFirstDiff = allNewRowsLeft.get(0).getTableName();
        }
        if (allNewRowsRight.isEmpty()) {
            count++;
        } else {
            tableOfFirstDiff = allNewRowsRight.get(0).getTableName();
        }
        if (count == 3) {
            JOptionPane.showMessageDialog(null, "the databases are completely equal");
        } else {
            return true;
        }
        return false;
    }

    public LinkedList<Table> getEqualTables(LinkedList<Table> tablesLeft, LinkedList<Table> tablesRight) {
        LinkedList<Table> liAllEqualTables = new LinkedList<>();
        for (Table tL : tablesLeft) {
            for (Table tR : tablesRight) {
                if (tL.getTableName().equals(tR.getTableName())) {
                    liAllEqualTables.add(tL);
                }
            }
        }
        return liAllEqualTables;
    }

    /**
     * This method ensures the lists containing the differences in rows and
     * columns are being cleared, for further usage.
     */
    public void clearCompareOutputLists() {
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

    /**
     * This method creates a HTML file displaying the content of each table of a
     * database.
     *
     * @param dbName
     * @param list
     * @param newHtmlFile
     * @throws IOException
     */
    public void viewDatabaseFileHTML(String dbName, LinkedList<Table> list, File newHtmlFile) throws IOException {
        File htmlTemplateFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "res" + File.separator + "template.html");
        System.out.println(htmlTemplateFile.getPath());
        String htmlString = FileUtils.readFileToString(htmlTemplateFile);
        String title = newHtmlFile.getName();
        String body = "<h1 style=\"font-family: Arial; font-size: 40px; margin-left: 25%; margin-bottom: 30px; "
                + "margin-top: 30px;\">" + dbName + "</h1><div id=\"content\" style=\"font-family: Arial; "
                + "font-size:13px; width: 800px; margin-left: 25%;\">";
        for (Table t : list) {
            body = body.concat("<table border=\"2\" style=\"border-collapse: collapse;\"><h2>");
            body = body.concat(t.getTableName() + "</h2><thead><tr>");
            for (String col : t.getColumnNames()) {
                body = body.concat("<th>" + col);
            }
            body = body.concat("</tr></thead>");
            for (Row r : t.getAttributes()) {
                body = body.concat("<tr style=\"padding:5px; margin:5px;\">");
                for (String str : r.getValue().split(";")) {
                    body = body.concat("<td>" + str + "</td>");
                }
                body = body.concat("</tr>");
            }
            body = body.concat("</table>");
        }
        body = body.concat("</div>");

        htmlString = htmlString.replace("$title", title);
        htmlString = htmlString.replace("$body", body);

        FileUtils.writeStringToFile(newHtmlFile, htmlString);
    }
}
