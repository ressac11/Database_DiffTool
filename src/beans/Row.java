package beans;

public class Row {
    private int RID;
    private String value;

    public Row(int RID, String value) {
        this.RID = RID;
        this.value = value;
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

    @Override
    public String toString() {
        return "Row{" + "RID=" + RID + ", value=" + value + '}';
    }
}