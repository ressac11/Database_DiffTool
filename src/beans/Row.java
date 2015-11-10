package beans;

public class Row {
    private int RID;
    private String value;
    private String primaryKey;

    public Row(int RID, String value, String primaryKey) {
        this.RID = RID;
        this.value = value;
        this.primaryKey = primaryKey;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public String toString() {
        return value;
    }
    
    
}