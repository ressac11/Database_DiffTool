package bl;

import beans.ColumnInformation;
import beans.DifferentCell;
import beans.DifferentColumn;
import beans.DifferentRow;
import beans.Row;
import beans.Table;
import gui.MainWindow;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BLOperations {

    private final String dbDelim = "#++++++++++++++++++++++++++++++++++++++++++++++++++#";
    private final String tableDelim = "#----------------------------------------------------------#";
    private final String delim = "#";
    private final String pkDelim = "--";
    private String tableOfFirstDiff = null;
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
    private Document doc;

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
                if (oldValue.getPrimaryKey().equals("")) {
                    bw.write(oldValue.getValue() + pkDelim + "0" + delim);
                } else {
                    bw.write(oldValue.getValue() + pkDelim + oldValue.getPrimaryKey() + delim);
                }

                for (int i = 1; i < rows.size(); i++) {
                    Row r2 = rows.get(i);
                    if (r2.getRID() != oldValue.getRID()) {
                        bw.newLine();
                        oldValue = r2;
                    }
                    if (r2.getPrimaryKey().equals("")) {
                        bw.write(r2.getValue() + pkDelim + "0" + delim);
                    } else {
                        bw.write(r2.getValue() + pkDelim + r2.getPrimaryKey() + delim);
                    }
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
    public void compareDatabases(String companyNameLeft, String companyNameRight, LinkedList<Table> tablesLeft, LinkedList<Table> tablesRight, MainWindow mw) {
        companyLeft = companyNameLeft;
        companyRight = companyNameRight;
        allNewColsLeft.clear();
        allNewColsRight.clear();
        allNewRowsLeft.clear();
        allNewRowsRight.clear();
        allNewCellsLeft.clear();
        allNewCellsRight.clear();
        System.out.println("tablesLeft.size: "+ tablesLeft.size());
        System.out.println("tablesRight.size: "+ tablesRight.size());
        LinkedList<Table> liAllTablesLeft = (LinkedList<Table>) tablesLeft.clone();
        LinkedList<Table> liAllTablesRight = (LinkedList<Table>) tablesRight.clone();
        LinkedList<String> liTempLeft = new LinkedList<>();
        LinkedList<String> liTempRight = new LinkedList<>();
        int count = 0;
        for (Table tR : liAllTablesRight) {
            liTempRight.add(tR.getTableName());
        }
        for (Table tL : liAllTablesLeft) {
            liTempLeft.add(tL.getTableName());
        }
        System.out.println("++++++++++++++"+liAllTablesLeft.size());
        System.out.println("------------------"+liAllTablesRight.size());
        if (liAllTablesLeft.size() < liAllTablesRight.size()) {
            for (Table lT : liAllTablesLeft) {
                for (Table rT : liAllTablesRight) {
                    int index = liAllTablesRight.indexOf(rT);
                    if (liTempLeft.contains(liTempRight.get(index))) {
                        if (lT.getTableName().equals(liAllTablesRight.get(index).getTableName())) {
                            count++;
                            mw.setCompareStatus(10);
                            compare(lT, rT, mw);
                        }
                    }
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "The tables can not be compared because non are equal");
            }
            count = 0;
        } else {
            for (Table rT : liAllTablesRight) {
                for (Table lT : liAllTablesLeft) {
                    int index = liAllTablesLeft.indexOf(lT);
                    if (liTempRight.contains(liTempLeft.get(index))) {
                        if (rT.getTableName().equals(liAllTablesLeft.get(index).getTableName())) {
                            count++;
                            mw.setCompareStatus(10);
                            compare(lT, rT, mw);
                        }
                    }
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(null, "The tables can not be compared because non are equal");
            }
            count = 0;
        }

    }

    /**
     * This method is responsible for the actual comparing process of two
     * particular tables.
     *
     * @param tLeft
     * @param tRight
     */
    private void compare(Table tLeft, Table tRight, MainWindow mw) 
    {
        LinkedList<String> colLeft = tLeft.getColumnNames();
        LinkedList<String> colRight = tRight.getColumnNames();
        LinkedList<String> clonedColRight = (LinkedList<String>) colRight.clone();
        LinkedList<String> clonedColLeft = (LinkedList<String>) colLeft.clone();
        ArrayList<Integer> colsRemoveRight = new ArrayList<>();
        ArrayList<Integer> colsRemoveLeft = new ArrayList<>();

        //determine different columns
        //different columns in the right database
        for (int i = 0; i < clonedColRight.size(); i++) {
            if (!clonedColLeft.contains(clonedColRight.get(i))) {
                DifferentColumn newColR = new DifferentColumn(tRight.getTableName(), clonedColRight.get(i), i);
                allNewColsRight.add(newColR);
                colsRemoveRight.add(i);
                if (tableOfFirstDiff == null) {
                    tableOfFirstDiff = tLeft.getTableName();
                }
            }
        }
        mw.setCompareStatus(20);
        //remove the different columns from the list for further comparing
        int index = 0;
        for (int temp = colsRemoveRight.size() - 1; temp >= 0; temp--) {
            index = colsRemoveRight.get(temp);
            clonedColRight.remove(clonedColRight.get(index));
        }
        mw.setCompareStatus(25);
        //different columns in the left database
        for (int i = 0; i < clonedColLeft.size(); i++) {
            if (!clonedColRight.contains(clonedColLeft.get(i))) {
                DifferentColumn newColL = new DifferentColumn(tLeft.getTableName(), clonedColLeft.get(i), i);
                allNewColsLeft.add(newColL);
                colsRemoveLeft.add(i);
                if (tableOfFirstDiff == null) {
                    tableOfFirstDiff = tLeft.getTableName();
                }
            }
        }
        mw.setCompareStatus(30);
        //remove the different columns from the list for further comparing
        index = 0;
        for (int temp = colsRemoveLeft.size() - 1; temp >= 0; temp--) {
            index = colsRemoveLeft.get(temp);
            clonedColLeft.remove(clonedColLeft.get(index));
        }

        LinkedList<Row> leftV = (LinkedList<Row>) tLeft.getAttributes().clone();
        LinkedList<Row> rightV = (LinkedList<Row>) tRight.getAttributes().clone();
        LinkedList<String> valuesRight = new LinkedList<>();
        LinkedList<String> valuesLeft = new LinkedList<>();
        LinkedList<String> liLeftPrimaryKeys = new LinkedList<>();
        LinkedList<String> liRightPrimaryKeys = new LinkedList<>();

        String valueTemp = "";
        int counter = 0;
        //write all primary keys into a list
        if (!leftV.isEmpty()) {
            for (Row r : leftV) {
                liLeftPrimaryKeys.add(r.getPrimaryKey());
            }
        }
        if (!rightV.isEmpty()) {
            for (Row r : rightV) {
                liRightPrimaryKeys.add(r.getPrimaryKey());
            }
        }
        mw.setCompareStatus(32);
//      in this process every value of a column which exists 
//      in both databases filtered and added to a new list as String value
//      this process is neccessary for comparing the values of the rows_list with 
//      each other (columns with exist in both databases are not included!)
        boolean removeCol = false;
        if (!rightV.isEmpty()) {
            for (Row r : rightV) {
                if (!allNewColsRight.isEmpty()) {
                    for (DifferentColumn col : allNewColsRight) {
                        if (tRight.getTableName().equals(col.getTableName())) {
                            for (String str : r.getValue().split(";")) {
                                if (!removeCol) {
                                    if (counter != col.getColumnIndex()) {
                                        valueTemp += str + ";";
                                    } else {
                                        removeCol = true;
                                    }
                                    counter++;
                                }
                            }
                            if (!valuesRight.contains(valueTemp)) {
                                valuesRight.add(valueTemp);

                            }
                            removeCol = false;
                        }
                    }
                    if (valuesRight.isEmpty()) {
                        for (Row r2 : rightV) {
                            valuesRight.add(r2.getValue());
                        }
                    }
                } else {
                    valuesRight.add(r.getValue());
                }
                counter = 0;
                valueTemp = "";
            }
        }
        counter = 0;
        valueTemp = "";
        mw.setCompareStatus(50);

//      in this process every value of a column which exists 
//      in both databases filtered and added to a new list as String value
//      this process is neccessary for comparing the values of the rows_list with 
//      each other (columns with exist in both databases are not included!)
        removeCol = false;
        if (!leftV.isEmpty()) {
            for (Row r : leftV) {
                if (!allNewColsLeft.isEmpty()) {
                    for (DifferentColumn col : allNewColsLeft) {
                        if (tLeft.getTableName().equals(col.getTableName())) {
                            for (String str : r.getValue().split(";")) {
                                if (!removeCol) {
                                    if (counter != col.getColumnIndex()) {
                                        valueTemp += str + ";";
                                    } else {
                                        removeCol = true;
                                    }
                                    counter++;
                                }
                            }
                            if (!valuesLeft.contains(valueTemp)) {
                                valuesLeft.add(valueTemp);
                            }
                            removeCol = false;
                        }
                    }
                    if (valuesLeft.isEmpty()) {
                        for (Row r2 : leftV) {
                            valuesLeft.add(r2.getValue());
                        }
                    }
                } else {
                    valuesLeft.add(r.getValue());
                }
                counter = 0;
                valueTemp = "";
            }
        }
        mw.setCompareStatus(65);

        //determine different rows_list and cells_list in the right table
        String[] arrayL = null;
        String[] arrayR = null;

        if (!valuesLeft.isEmpty()) {
            if (!valuesRight.isEmpty()) {
                for (int rL = 0; rL < valuesLeft.size(); rL++) {
                    arrayL = valuesLeft.get(rL).split(";");
                    for (int rR = 0; rR < valuesRight.size(); rR++) {
                        arrayR = valuesRight.get(rR).split(";");

                        if (liLeftPrimaryKeys.contains(rightV.get(rR).getPrimaryKey())) {
                            if (leftV.get(rL).getPrimaryKey().equals(rightV.get(rR).getPrimaryKey())) {
                                for (int indexColR = 0; indexColR < arrayR.length; indexColR++) {
                                    int indexColL = clonedColLeft.indexOf(clonedColRight.get(indexColR));
                                    if (!arrayL[indexColL].equals(arrayR[indexColR])) {
                                        DifferentCell diffCellR = new DifferentCell(tRight.getTableName(), indexColR, rR, arrayR[indexColR]);
                                        diffCellR.toString();
                                        allNewCellsRight.add(diffCellR);
                                        if (tableOfFirstDiff == null) {
                                            tableOfFirstDiff = tLeft.getTableName();
                                        }
                                    }
                                }
                                //                            break;
                            }
                        } else {
                            DifferentRow diffRowR = new DifferentRow(tRight.getTableName(), rightV.get(rR).getValue(), rR);
                            if (!allNewRowsRight.contains(diffRowR)) {
                                allNewRowsRight.add(diffRowR);
                                if (tableOfFirstDiff == null) {
                                    tableOfFirstDiff = tLeft.getTableName();
                                }
                            }
                        }

                    }
                }
            }
        }
        mw.setCompareStatus(80);
        //determine different rows_list and cells_list in the left table
        arrayL = null;
        arrayR = null;
        if (!valuesRight.isEmpty()) {
            if (!valuesLeft.isEmpty()) {
                for (int rR = 0; rR < valuesRight.size(); rR++) {
                    arrayR = valuesRight.get(rR).split(";");
                    for (int rL = 0; rL < valuesLeft.size(); rL++) {
                        arrayL = valuesLeft.get(rL).split(";");
                        if (liRightPrimaryKeys.contains(leftV.get(rL).getPrimaryKey())) {
                            if (rightV.get(rR).getPrimaryKey().equals(leftV.get(rL).getPrimaryKey())) {
                                for (int indexColL = 0; indexColL < arrayL.length; indexColL++) {
                                    int indexColR = clonedColRight.indexOf(clonedColLeft.get(indexColL));
                                    if (!arrayR[indexColR].equals(arrayL[indexColL])) {
                                        DifferentCell diffCellL = new DifferentCell(tLeft.getTableName(), indexColL, rL, arrayL[indexColL]);
                                        diffCellL.toString();
                                        allNewCellsLeft.add(diffCellL);
                                        if (tableOfFirstDiff == null) {
                                            tableOfFirstDiff = tLeft.getTableName();
                                        }
                                    }
                                }
                                //                            break;
                            }
                        } else {
                            DifferentRow diffRowL = new DifferentRow(tLeft.getTableName(), leftV.get(rL).getValue(), rL);
                            if (!allNewRowsLeft.contains(diffRowL)) {
                                allNewRowsLeft.add(diffRowL);
                                if (tableOfFirstDiff == null) {
                                    tableOfFirstDiff = tLeft.getTableName();
                                }
                            }
                        }
                    }
                }
            }
        }
        mw.setCompareStatus(100);
    }

    /**
     * This method ensures whether there are any differences between those
     * databases found and returns true if so. This method is needed to know
     * whether to enable the download function.
     *
     * @return
     */
    public boolean differencesOccuring() {
        boolean differencesOccuring = true;
        if (allNewColsLeft.isEmpty() && allNewColsRight.isEmpty() && allNewCellsLeft.isEmpty() && allNewCellsRight.isEmpty() && allNewRowsLeft.isEmpty() && allNewRowsRight.isEmpty()) {
            differencesOccuring = false;
        }
        return differencesOccuring;
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
     * This method ensures the lists containing the differences in rows_list and
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

    public LinkedList<DifferentCell> getAllNewCellsRight() {
        return allNewCellsRight;
    }

    public LinkedList<DifferentCell> getAllNewCellsLeft() {
        return allNewCellsLeft;
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
    public void viewDatabaseFileHTML(String dbName, LinkedList<Table> list, File newHtmlFile) throws IOException 
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(newHtmlFile));
        String htmlString = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \n"
                + "\"http://www.w3.org/TR/html4/loose.dtd\">\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "<title>$title</title>\n"
                + "</head>\n"
                + "<body style=\"background-color: #e5e5e5;\">$body\n"
                + "</body>\n"
                + "</html>";
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
        bw.write(htmlString);
        bw.flush();
        bw.close();
    }

    /**
     * This method creates a xml file displaying the differences occuring in the
     * database.
     *
     * @param filename
     * @throws ParserConfigurationException
     * @throws TransformerConfigurationException
     * @throws FileNotFoundException
     * @throws TransformerException
     */
    public void downloadDifferencesAsXML(String filename) throws ParserConfigurationException, TransformerConfigurationException, FileNotFoundException, TransformerException {
        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dfactory.newDocumentBuilder();
        doc = builder.newDocument();
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute("indent-number", 4); //indent: Einrückung der Elemente in der xml-Datei
        Transformer trafo = factory.newTransformer();
        trafo.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        trafo.setOutputProperty(OutputKeys.INDENT, "yes");
        trafo.setOutputProperty(OutputKeys.METHOD, "xml");
        Result result = new StreamResult(new OutputStreamWriter(new FileOutputStream(filename)));

        Element main = doc.createElement("Differences");
        Element differencesDB1 = doc.createElement(companyLeft);
        writeDifferencesXML(differencesDB1, allNewColsLeft, allNewRowsLeft, allNewCellsLeft);
        main.appendChild(differencesDB1);

        Element differencesDB2 = doc.createElement(companyRight);
        writeDifferencesXML(differencesDB2, allNewColsRight, allNewRowsRight, allNewCellsRight);
        main.appendChild(differencesDB2);
        doc.appendChild(main);

        trafo.transform(new DOMSource(doc), result);
    }

    /**
     * This method writes the differences onto a DomDocument.
     *
     * @param e
     * @param cols
     * @param rows
     * @param cells
     */
    public void writeDifferencesXML(Element e, LinkedList<DifferentColumn> cols, LinkedList<DifferentRow> rows, LinkedList<DifferentCell> cells) {

        Element columns = doc.createElement("Columns");

        for (DifferentColumn col : cols) {
            Element column = doc.createElement("Column");
            column.setAttribute("table_name", col.getTableName());
            column.setAttribute("index", col.getColumnIndex() + "");
            column.setTextContent(col.getColumnName());
            columns.appendChild(column);
        }
        e.appendChild(columns);

        Element rows_list = doc.createElement("Rows");

        for (DifferentRow r : rows) {
            Element row = doc.createElement("Row");
            row.setAttribute("table_name", r.getTableName());
            row.setAttribute("index", r.getRowIndex() + "");
            row.setTextContent(r.getValue());
            rows_list.appendChild(row);
        }
        e.appendChild(rows_list);

        Element cells_list = doc.createElement("Cells");

        for (DifferentCell c : cells) {
            Element cell = doc.createElement("Cell");
            cell.setAttribute("table_name", c.getTableName());
            cell.setAttribute("column_index", c.getColumnIndex() + "");
            cell.setAttribute("row_index", c.getRowIndex() + "");
            cell.setTextContent(c.getValue());
            cells_list.appendChild(cell);
        }
        e.appendChild(cells_list);
    }

}