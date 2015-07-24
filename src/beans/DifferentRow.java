package beans;

public class DifferentRow 
{
    private String tableName;
    private String value;
    private int rowIndex;

    public DifferentRow(String tableName, String value, int rowIndex) {
        this.tableName = tableName;
        this.value = value;
        this.rowIndex = rowIndex;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getRowIndex() {
        return rowIndex;
    }
}