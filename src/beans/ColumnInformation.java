package beans;

public class ColumnInformation 
{
    private String tableName;
    private int columnIndex;
    private String columnName;

    public ColumnInformation(String tableName, int columnIndex, String columnName) {
        this.tableName = tableName;
        this.columnIndex = columnIndex;
        this.columnName = columnName;
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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }}