package gt.cs4420.relationaldb.database.storage;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import gt.cs4420.relationaldb.database.query.QueryParser;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.test.TestFailedException;

import java.util.Map;
import java.util.Set;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

/**
 * A basic class to test the functionality of the StorageManager. For now, the tests will just be run through the main
 * method. Later, we can consider implementing unit tests for all aspects of our system.
 */
public class StorageManagerTest {

    private final String DB_ROOT_DIRECTORY = "database/test/";

    public static void main(String[] args) {
        StorageManagerTest test = new StorageManagerTest();
        test.run();
        String query = "";
        
        for(int i = 0; i < 5; i++){
            int choice = i;

            switch(choice)
            {
                case 0:
                    query = "SELECT userId, email, username, password " +
                            "FROM users " +
                            "INNER JOIN posts " +
                            "ON users.userId=posts.userId " +
                            "WHERE username = 'reid' " +
                            "ORDER BY username ASC;";
                    break;

                case 1:
                    query = "INSERT INTO users " +
                            "(" +
                            "	userId, " +
                            "	username, " +
                            "	email, " +
                            "	password" +
                            ") " +
                            "VALUES " +
                            "(" +
                            "	60, " +
                            "	'phil', " +
                            "	'poliver@gatech.edu', " +
                            "	'unicorns' " +
                            ");";
                    break;

                case 2:
                    query = "UPDATE users " +
                            "SET " +
                            "username = 'phil', " +
                            "email = 'poliver@gatech.edu' " +
                            "WHERE userId = 1;";
                    break;

                case 3:
                    query = "CREATE TABLE pimps " +
                            "(" +
                            "	nameID int FOREIGN KEY, " +
                            "	name varchar(10000)" +
                            ");";
                    break;

                case 4:
                    query = "DROP TABLE users;";
                    break;
                default:
                    break;
            }

            QueryParser parser = null;

            try {
                 parser = new QueryParser(query);
            } catch (RecognitionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            DOTTreeGenerator gen = new DOTTreeGenerator();
            CommonTree queryTree = parser.getQueryTree();
            StringTemplate st = gen.toDOT(queryTree);

            // This prints out a DOT Tree declaration for the query tree. Use GraphViz to view it.
            System.out.println(st);

        }

    }

    private final StorageManager manager;

    private StorageManagerTest() {
        manager = new StorageManager(DB_ROOT_DIRECTORY);

        //Currently force exporting to test in-memory and on-disk
        StorageData.exportDisabled = false;
        StorageData.ignoreDirty = false;
        StorageData.forceFlush = true;
    }

    private void run() {

        //Clear any old test data that still exists
        manager.clearDatabase();

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

        Table usersTable = new Table("users", usersDescription);
        testCreateTable(usersTable);

        //Build post Table
        Attribute[] postAttrs = new Attribute[3];
        postAttrs[0] = new Attribute(DataType.INT, "postId");
        postAttrs[1] = new Attribute(DataType.INT, "userId");
        postAttrs[2] = new Attribute(DataType.STRING, "post");

        Description postsDescription = new Description();
        postsDescription.setAttributes(postAttrs);
        postsDescription.setPrimaryKeyAttribute(postAttrs[0]);

        Table postsTable = new Table("posts", postsDescription);
        testCreateTable(postsTable);

        //Build followers Table
        Attribute[] followerAttrs = new Attribute[3];
        followerAttrs[0] = new Attribute(DataType.INT, "followId");
        followerAttrs[1] = new Attribute(DataType.INT, "followerId");
        followerAttrs[2] = new Attribute(DataType.INT, "followedId");

        Description followerDescription = new Description();
        followerDescription.setAttributes(followerAttrs);
        followerDescription.setPrimaryKeyAttribute(followerAttrs[0]);

        Table followersTable = new Table("followers", followerDescription);
        testCreateTable(followersTable);

        //Build a test Set
        Set<Table> testTableSet = Sets.newHashSet();
        testTableSet.add(usersTable);
        testTableSet.add(postsTable);
        testTableSet.add(followersTable);

        //Test getTable
        testGetTable("users", usersTable);
        testGetTable("posts", postsTable);
        testGetTable("followers", followersTable);

        //Test insert
        Row userRow1 = new Row();
        userRow1.setPrimaryKey(0);
        Map<Attribute, Object> user1Attrs = Maps.newHashMap();
        user1Attrs.put(userAttrs[0], 0);
        user1Attrs.put(userAttrs[1], "reid");
        user1Attrs.put(userAttrs[2], "rharr90@gmail.com");
        user1Attrs.put(userAttrs[3], "reidpass");
        userRow1.setRowData(user1Attrs);
        testInsert(usersTable.getId(), userRow1.getRowData());

        Row userRow2 = new Row();
        userRow2.setPrimaryKey(1);
        Map<Attribute, Object> user2Attrs = Maps.newHashMap();
        user2Attrs.put(userAttrs[0], 1);
        user2Attrs.put(userAttrs[1], "phil");
        user2Attrs.put(userAttrs[2], "sortofrican90@gmail.com");
        user2Attrs.put(userAttrs[3], "philpass");
        userRow2.setRowData(user2Attrs);
        testInsert(usersTable.getId(), userRow2.getRowData());

        Row userRow3 = new Row();
        userRow3.setPrimaryKey(2);
        Map<Attribute, Object> user3Attrs = Maps.newHashMap();
        user3Attrs.put(userAttrs[0], 2);
        user3Attrs.put(userAttrs[1], "bruce");
        user3Attrs.put(userAttrs[2], "chenhao.liu@gmail.com");
        user3Attrs.put(userAttrs[3], "brucepass");
        userRow3.setRowData(user3Attrs);
        testInsert(usersTable.getId(), userRow3.getRowData());

        Row userRow4 = new Row();
        userRow4.setPrimaryKey(3);
        Map<Attribute, Object> user4Attrs = Maps.newHashMap();
        user4Attrs.put(userAttrs[0], 3);
        user4Attrs.put(userAttrs[1], "jeff");
        user4Attrs.put(userAttrs[2], "jeff.drasher@gmail.com");
        user4Attrs.put(userAttrs[3], "jeffpass");
        userRow4.setRowData(user4Attrs);
        testInsert(usersTable.getId(), userRow4.getRowData());

        Row postRow1 = new Row();
        postRow1.setPrimaryKey(0);
        Map<Attribute, Object> post1Attrs = Maps.newHashMap();
        post1Attrs.put(postAttrs[0], 0);
        post1Attrs.put(postAttrs[1], 0);
        post1Attrs.put(postAttrs[2], "This is the first post");
        postRow1.setRowData(post1Attrs);
        testInsert(postsTable.getId(), postRow1.getRowData());

        Row postRow2 = new Row();
        postRow2.setPrimaryKey(1);
        Map<Attribute, Object> post2Attrs = Maps.newHashMap();
        post2Attrs.put(postAttrs[0], 1);
        post2Attrs.put(postAttrs[1], 1);
        post2Attrs.put(postAttrs[2], "This is the second post");
        postRow2.setRowData(post2Attrs);
        testInsert(postsTable.getId(), postRow2.getRowData());

        Row postRow3 = new Row();
        postRow3.setPrimaryKey(2);
        Map<Attribute, Object> post3Attrs = Maps.newHashMap();
        post3Attrs.put(postAttrs[0], 2);
        post3Attrs.put(postAttrs[1], 2);
        post3Attrs.put(postAttrs[2], "This is the third post");
        postRow3.setRowData(post3Attrs);
        testInsert(postsTable.getId(), postRow3.getRowData());

        Row postRow4 = new Row();
        postRow4.setPrimaryKey(3);
        Map<Attribute, Object> post4Attrs = Maps.newHashMap();
        post4Attrs.put(postAttrs[0], 3);
        post4Attrs.put(postAttrs[1], 3);
        post4Attrs.put(postAttrs[2], "This is the fourth post");
        postRow4.setRowData(post4Attrs);
        testInsert(postsTable.getId(), postRow4.getRowData());

        Row followerRow1 = new Row();
        followerRow1.setPrimaryKey(0);
        Map<Attribute, Object> follower1Attrs = Maps.newHashMap();
        follower1Attrs.put(followerAttrs[0], 0);
        follower1Attrs.put(followerAttrs[1], 1);
        follower1Attrs.put(followerAttrs[2], 0);
        followerRow1.setRowData(follower1Attrs);
        testInsert(followersTable.getId(), followerRow1.getRowData());

        Row followerRow2 = new Row();
        followerRow2.setPrimaryKey(1);
        Map<Attribute, Object> follower2Attrs = Maps.newHashMap();
        follower2Attrs.put(followerAttrs[0], 1);
        follower2Attrs.put(followerAttrs[1], 2);
        follower2Attrs.put(followerAttrs[2], 0);
        followerRow2.setRowData(follower2Attrs);
        testInsert(followersTable.getId(), followerRow2.getRowData());

        Row followerRow3 = new Row();
        followerRow3.setPrimaryKey(2);
        Map<Attribute, Object> follower3Attrs = Maps.newHashMap();
        follower3Attrs.put(followerAttrs[0], 2);
        follower3Attrs.put(followerAttrs[1], 1);
        follower3Attrs.put(followerAttrs[2], 3);
        followerRow3.setRowData(follower3Attrs);
        testInsert(followersTable.getId(), followerRow3.getRowData());

    }

    private void testCreateTable(final Table table) {
        try {
            manager.createTable(table);
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new TestFailedException("Create table", e.getMessage());
        }
    }

    private void testGetTable(final String tableName, final Table expectedTable) {
        Table receivedTable = manager.getTable(tableName);

        if (receivedTable == null) {
            throw new TestFailedException("Get table", "table retrieved was null");
        }
        if (!expectedTable.equals(receivedTable)) {
            throw new TestFailedException("Get table", "table retrieved did not equal expected");
        }
    }

    private void testDropTable(final Integer tableId) {
        try {
            manager.dropTable(manager.getTableName(tableId));
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new TestFailedException("Drop table");
        }

        boolean dropValidationSuccess = false;

        //Try again to make sure this fails because table was dropped
        try {
            String tableName = manager.getTableName(tableId);

            if (Strings.isNullOrEmpty(tableName)) {
                dropValidationSuccess = true;
            } else {
                manager.dropTable(tableName);
            }
        } catch (ValidationException e) {
            dropValidationSuccess = true;
        } finally {
            if (!dropValidationSuccess) {
                throw new TestFailedException("Drop table", "Table was not successfully dropped and still believed to exist");
            }
        }

    }

    private void testInsert(final Integer tableId, Map<Attribute, Object> attributes) {
        try {
            Row row = new Row();
            row.setRowData(attributes);

            manager.insert(manager.getTableName(tableId), row);
        } catch (final ValidationException ve) {
            ve.printStackTrace();
            throw new TestFailedException("Insert");
        }

        //TODO Implement check that items were inserted
    }

}
