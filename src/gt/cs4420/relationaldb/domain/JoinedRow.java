package gt.cs4420.relationaldb.domain;

public class JoinedRow {

    private Integer leftPrimaryKey;
    private Integer rightPrimaryKey;

    private Row leftRow;
    private Row rightRow;

    public JoinedRow() {
        leftPrimaryKey = null;
        rightPrimaryKey = null;

        leftRow = null;
        rightRow = null;
    }

    public Integer getLeftPrimaryKey() {
        return leftPrimaryKey;
    }

    public void setLeftPrimaryKey(final Integer leftPrimaryKey) {
        this.leftPrimaryKey = leftPrimaryKey;
    }

    public Integer getRightPrimaryKey() {
        return rightPrimaryKey;
    }

    public void setRightPrimaryKey(final Integer rightPrimaryKey) {
        this.rightPrimaryKey = rightPrimaryKey;
    }

    public Row getLeftRow() {
        return leftRow;
    }

    public void setLeftRow(final Row leftRow) {
        this.leftRow = leftRow;
    }

    public Row getRightRow() {
        return rightRow;
    }

    public void setRightRow(final Row rightRow) {
        this.rightRow = rightRow;
    }
}
