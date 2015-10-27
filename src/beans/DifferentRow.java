package beans;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "DifferentRow{" + "tableName=" + tableName + ", value=" + value + ", rowIndex=" + rowIndex + '}';
    }

       @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DifferentRow other = (DifferentRow) obj;
        if (!Objects.equals(this.tableName, other.tableName)) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (this.rowIndex != other.rowIndex) {
            return false;
        }
        return true;
    }

    
}