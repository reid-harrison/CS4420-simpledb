package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.test.TestFailedException;

import java.util.Set;

public class FileManagerTest {

    private final String DB_ROOT_DIRECTORY = "test/database";

    private FileManager manager;

    public void run() {
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

        Table followersTable = new Table(3, "followers", followerDescription);

        //Build a test Set
        Set<Table> testTableSet = Sets.newHashSet();
        testTableSet.add(usersTable);
        testTableSet.add(postsTable);
        testTableSet.add(followersTable);

        /**
         * Run tests
         */
        testExportDescriptions(testTableSet);
        testImportDescriptions(testTableSet);

    }

    private void testExportDescriptions(final Set<Table> tables) {
        manager.exportDescriptions(tables);
    }

    private void testImportDescriptions(final Set<Table> expectedTables) {
        Set<Table> receivedTables = manager.importDescriptions();

        if (receivedTables == null) {
            throw new TestFailedException("Import descriptions", "received set of tables is null");
        }

        if (!expectedTables.equals(receivedTables)) {
            throw new TestFailedException("Import descriptions", "received set of tables does not equal expected");
        }
    }
}
