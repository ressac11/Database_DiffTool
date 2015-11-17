package beans;

public class DifferentColumn 
{
    private String tableName;
    private String columnName;
    private int columnIndex;

    public DifferentColumn(String tableName, String columnName, int columnIndex) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.columnIndex = columnIndex;
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
    public String toString() {
        return "DifferentColumn{" + "tableName=" + tableName + ", columnName=" + columnName + ", columnIndex=" + columnIndex + '}';
    }

   
}

