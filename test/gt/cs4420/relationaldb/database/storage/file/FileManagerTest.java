package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.test.TestFailedException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileManagerTest {

    public static void main(String[] args) {
        FileManagerTest test = new FileManagerTest();
        test.run();
    }

    private final String DB_ROOT_DIRECTORY = "database/test/";

    private FileManager manager;

    private void run() {
        manager = new FileManager(DB_ROOT_DIRECTORY);

        /**
         * Build test Tables
         */
        //Build user Table
        Attribute[] userAttrs = new Attribute[4];
        userAttrs[0] = new Attribute(DataType.INT, "userId");
        userAttrs[1] = new Attribute(DataType.STRING, "username");
        userAttrs[2] = new Attribute(DataType.STRING, "email");
        userAttrs[3] = new Attribute(DataType.STRING, "password");

        Description usersDescription = new Description();
        usersDescription.setAttributes(userAttrs);
        usersDescription.setPrimaryKeyAttribute(userAttrs[0]);

        Table usersTable = new Table(0, "users", usersDescription);

        //Build post Table
        Attribute[] postAttrs = new Attribute[3];
        postAttrs[0] = new Attribute(DataType.INT, "postId");
        postAttrs[1] = new Attribute(DataType.INT, "userId");
        postAttrs[2] = new Attribute(DataType.STRING, "post");

        Description postsDescription = new Description();
        postsDescription.setAttributes(postAttrs);
        postsDescription.setPrimaryKeyAttribute(postAttrs[0]);

        Table postsTable = new Table(1, "posts", postsDescription);

        //Build followers Table
        Attribute[] followerAttrs = new Attribute[3];
        followerAttrs[0] = new Attribute(DataType.INT, "followId");
        followerAttrs[1] = new Attribute(DataType.INT, "followerId");
        followerAttrs[2] = new Attribute(DataType.INT, "followeeId");

        Description followerDescription = new Description();
        followerDescription.setAttributes(followerAttrs);
        followerDescription.setPrimaryKeyAttribute(followerAttrs[0]);

        Table followersTable = new Table(2, "followers", followerDescription);

        //Build a test Set
        Set<Table> testTableSet = Sets.newHashSet();
        testTableSet.add(usersTable);
        testTableSet.add(postsTable);
        testTableSet.add(followersTable);

        /**
         * Run Export Description tests
         */
        testExportDescriptions(testTableSet);
        testImportDescriptions(testTableSet);


        /**
         * Build User data
         */
        int usersBlockSize = 4;

        Row row1 = new Row();
        row1.setPrimaryKey(0);
        Map<Attribute, Object> user1Attrs = Maps.newHashMap();
        user1Attrs.put(userAttrs[0], 0);
        user1Attrs.put(userAttrs[1], "reid");
        user1Attrs.put(userAttrs[2], "rharr90@gmail.com");
        user1Attrs.put(userAttrs[3], "reidpass");
        row1.setRowData(user1Attrs);

        Row row2 = new Row();
        row2.setPrimaryKey(1);
        Map<Attribute, Object> user2Attrs = Maps.newHashMap();
        user2Attrs.put(userAttrs[0], 1);
        user2Attrs.put(userAttrs[1], "phil");
        user2Attrs.put(userAttrs[2], "sortofrican90@gmail.com");
        user2Attrs.put(userAttrs[3], "philpass");
        row2.setRowData(user2Attrs);

        Row row3 = new Row();
        row3.setPrimaryKey(2);
        Map<Attribute, Object> user3Attrs = Maps.newHashMap();
        user3Attrs.put(userAttrs[0], 3);
        user3Attrs.put(userAttrs[1], "bruce");
        user3Attrs.put(userAttrs[2], "chenhao.liu@gmail.com");
        user3Attrs.put(userAttrs[3], "brucepass");
        row3.setRowData(user3Attrs);

        List<Row> block1 = Lists.newArrayList();
        block1.add(row1);
        block1.add(row2);

        List<Row> block2 = Lists.newArrayList();
        block2.add(row3);

        /**
         * Test exporting and importing table blocks
         */
        List<Block> metaData = Lists.newArrayList();
        metaData.add(new Block(0, usersBlockSize * 2));
        metaData.add(new Block(1, usersBlockSize));
        testExportBlockMetaData(usersTable.getId(), metaData);

        testExportTableBlock(usersTable.getId(), 0, usersBlockSize * 2, block1);
        testImportTableBlock(usersTable.getId(), 0, usersTable.getDescription(), block1);

        testExportTableBlock(usersTable.getId(), 1, usersBlockSize, block2);
        testImportTableBlock(usersTable.getId(), 1, usersTable.getDescription(), block2);

        /**
         * Build Index data
         */
        IndexManager indexManager = new IndexManager();

        indexManager.createIndex(usersTable.getId());
        indexManager.createIndex(postsTable.getId());
        indexManager.createIndex(followersTable.getId());

        indexManager.addIndexEntry(usersTable.getId(), (Integer) block1.get(0).getRowData().get(userAttrs[0]), 0, 0);
        indexManager.addIndexEntry(usersTable.getId(), (Integer) block1.get(1).getRowData().get(userAttrs[0]), 0, 1);
        indexManager.addIndexEntry(usersTable.getId(), (Integer) block2.get(0).getRowData().get(userAttrs[0]), 1, 0);

        IndexManager importIndex = new IndexManager();
        importIndex.createIndex(usersTable.getId());
        importIndex.createIndex(postsTable.getId());
        importIndex.createIndex(followersTable.getId());

        /**
         * Test exporting and importing indexes
         */
        testExportIndexes(indexManager);
        testImportIndexes(importIndex, indexManager);

    }

    private void testExportDescriptions(final Set<Table> tables) {
        manager.exportDescriptions(tables);
    }

    private void testImportDescriptions(final Set<Table> expectedTables) {
        HashSet<Table> receivedTables = Sets.newHashSet(manager.importDescriptions());

        if (receivedTables == null) {
            throw new TestFailedException("Import descriptions", "received set of tables is null");
        }

        for (Table table : expectedTables) {
            if (!receivedTables.contains(table)) {
                throw new TestFailedException("Import descriptions", "received set of tables does not equal expected");
            }
        }

    }

    private void testExportBlockMetaData(final Integer tableId, final List<Block> metaBlocks) {
        manager.exportBlockMetaData(tableId, metaBlocks);
    }

    private void testExportTableBlock(final Integer tableId, final Integer blockId, final int blockSize, final List<Row> rowData) {
        manager.exportTableBlock(tableId, blockId, blockSize, rowData);
    }

    private void testImportTableBlock(final Integer tableId, final Integer blockId, final Description description, final List<Row> expectedRows) {
       Block importBlock = manager.importTableBlock(tableId, blockId, description);

        for (Row row : expectedRows) {
            if (!importBlock.getBlockData().contains(row.getRowData())) {
                throw new TestFailedException("Import table block", "received block does not equal expected");
            }
        }
    }

    private void testExportIndexes(final IndexManager indexManager) {
        manager.exportIndexes(indexManager);
    }

    private void testImportIndexes(final IndexManager indexManager, final IndexManager expectedIndexManager) {
        manager.importIndexes(indexManager);

        if (!expectedIndexManager.equals(indexManager)) {
            throw new TestFailedException("Import indexes", "Imported index manager does not equals expected");
        }

    }

}
