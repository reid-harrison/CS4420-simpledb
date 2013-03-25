package gt.cs4420.relationaldb.database.storage.block;

import gt.cs4420.relationaldb.domain.Row;

import java.util.List;

public class Block {

    //Currently the number of attribute it holds
    private Integer blockSize;
    private Integer blockId;
    private List<Row> rowData;

    public Block() {
        blockSize = null;
        blockId = null;
        rowData = null;
    }

    public Block(final Integer blockId) {
        this.blockId = blockId;
    }

    public Block(final Integer blockId, final List<Row> rowData) {
        this(blockId);
        this.rowData = rowData;
    }

    public Block(final Integer blockId, final Integer blockSize) {
        this(blockId);
        this.blockSize = blockSize;
    }

    public Block(final Integer blockId, final List<Row> rowData, final Integer blockSize) {
        this(blockId, rowData);
        this.blockSize = blockSize;
    }

    public void setBlockId(final Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockSize(final Integer blockSize) {
        this.blockSize = blockSize;
    }

    public Integer getBlockSize() {
        return blockSize;
    }

    public void setRowData(final List<Row> rowData) {
        this.rowData = rowData;
    }

    public List<Row> getBlockData() {
        return rowData;
    }
}
