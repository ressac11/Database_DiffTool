package beans;

public class NewColumns 
{
    private String companyName;
    private String tableName;
    private String columnName;
    private int columnIndex;

    public NewColumns(String companyName, String tableName, String columnName, int columnIndex) {
        this.companyName = companyName;
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnIndex = columnIndex;
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public String toString() 
    {
        return "Table name = " + tableName + ", Column name = " + columnName + ", Column index = " + columnIndex;
    } 
}