package gt.cs4420.relationaldb.run;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.query.QueryEngine;
import gt.cs4420.relationaldb.database.query.QueryParser;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.JoinedRow;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.BaseTree;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DatabaseRunner {

    public static void main(String[] args) {
        DatabaseRunner runner = new DatabaseRunner();
        runner.run();
    }

    private Scanner scanner;

    private QueryParser parser;
    private QueryEngine queryEngine;

    private DatabaseRunner() {
        scanner = new Scanner(System.in);
        queryEngine = new QueryEngine(new StorageManager());
    }

    private void run() {
        System.out.println("Welcome to our CS4420 Simple Relational Database!");
        System.out.println("Enter a query to begin...");

        while (true) {
            String query = "";

            while (!scanner.hasNext()) {

            }

            while (scanner.hasNext()) {
                String line = scanner.nextLine();

                if (!query.endsWith(" ") && !line.startsWith(" ")) {
                    query += " ";
                }

                query += line;

                if (line.endsWith(";")) {
                    break;
                }
            }

            try {
                parseQuery(query);
            } catch (final RecognitionException re) {
                System.out.println(re.getMessage());
                continue;
            } catch (ValidationException e) {
                for (String msg : e.getMessages()) {
                    System.out.println(msg);
                }

                continue;
			}

            CommonTree queryTree = parser.getQueryTree();

            if (isSelect(queryTree)) {
                if (isJoin(queryTree)) {
                    List<JoinedRow> returnedRows = queryEngine.selectFromJoinedTables(parser);
                    printJoinedRows(returnedRows);
                    continue;
                } else {
                    List<Row> returnedRows = queryEngine.selectFromTable(parser);
                    printRows(returnedRows);
                    continue;
                }
            } else {
                boolean success = false;

                try {
                    success = queryEngine.executeQuery(queryTree);

                    if (success) {
                        System.out.println("Query completed successfully!");
                    } else {
                        System.out.println("Query completed unsuccessfully...");
                    }

                } catch (final ValidationException ve) {
                    for (String msg : ve.getMessages()) {
                        System.out.println(msg);
                    }

                    continue;
                }
            }
        }
    }

    private void parseQuery(final String query) throws RecognitionException, ValidationException {
        parser = new QueryParser(query);
    }

    private boolean isSelect(final CommonTree query) {
        if("SELECT".equals(query.getChild(0).getText())) {
            return true;
        }

        return false;
    }

    private boolean isJoin(final CommonTree query) {
        Tree fromRoot = query.getChild(1);

        if ("JOIN".equals(fromRoot.getChild(0))) {
            return true;
        }

        return false;
    }

    private void printJoinedRows(final List<JoinedRow> rows) {
        List<Row> mergedDataRows = Lists.newArrayList();

        for (final JoinedRow row : rows) {
            Row leftRow = row.getLeftRow();
            Row rightRow = row.getRightRow();

            Row joined = new Row();

            Map<Attribute, Object> joinedData = Maps.newHashMap();
            joinedData.putAll(leftRow.getRowData());
            joinedData.putAll(rightRow.getRowData());
            joined.setRowData(joinedData);

            mergedDataRows.add(joined);
        }

        printRows(mergedDataRows);
    }

    private void printRows(final List<Row> rows) {
        int i = 0;

        for (Row row : rows) {
            Map<Attribute, Object> rowData = row.getRowData();

            StringBuilder sb = new StringBuilder();
            sb.append("(" + i + ") ");

            for (Attribute attr : rowData.keySet()) {
                Object val = rowData.get(attr);

                sb.append(attr.getName());
                sb.append(": ");
                sb.append(val.toString());
            }

            System.out.println(sb.toString());

            i++;
        }
    }
}
