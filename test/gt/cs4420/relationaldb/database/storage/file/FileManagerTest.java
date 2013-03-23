package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
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

        Map<Attribute, Object> user1Attrs = Maps.newHashMap();
        user1Attrs.put(userAttrs[0], 0);
        user1Attrs.put(userAttrs[1], "reid");
        user1Attrs.put(userAttrs[2], "rharr90@gmail.com");
        user1Attrs.put(userAttrs[3], "reidpass");

        Map<Attribute, Object> user2Attrs = Maps.newHashMap();
        user2Attrs.put(userAttrs[0], 1);
        user2Attrs.put(userAttrs[1], "phil");
        user2Attrs.put(userAttrs[2], "sortofrican90@gmail.com");
        user2Attrs.put(userAttrs[3], "philpass");

        Map<Attribute, Object> user3Attrs = Maps.newHashMap();
        user3Attrs.put(userAttrs[0], 3);
        user3Attrs.put(userAttrs[1], "bruce");
        user3Attrs.put(userAttrs[2], "chenhao.liu@gmail.com");
        user3Attrs.put(userAttrs[3], "brucepass");

        List<Map<Attribute, Object>> block1 = Lists.newArrayList();
        block1.add(user1Attrs);
        block1.add(user2Attrs);

        List<Map<Attribute, Object>> block2 = Lists.newArrayList();
        block2.add(user3Attrs);

        /**
         * Test exporting table blocks
         */
        testExportTableBlock(usersTable.getId(), 0, usersBlockSize * 2, block1);
        testExportTableBlock(usersTable.getId(), 0, usersBlockSize, block2);

        //TODO Lots more tests to do

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

    private void testExportTableBlock(final Integer tableId, final Integer blockId, final int blockSize, final List<Map<Attribute, Object>> blockData) {
        manager.exportTableBlock(tableId, blockId, blockSize, blockData);
    }

    private void testImportTableBlock() {
        //TODO Implement test
    }

}
