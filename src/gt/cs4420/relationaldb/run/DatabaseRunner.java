package gt.cs4420.relationaldb.run;

import gt.cs4420.relationaldb.database.query.QueryEngine;
import gt.cs4420.relationaldb.database.query.QueryParser;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import org.antlr.runtime.RecognitionException;

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
            }

            //TODO Run query and display results
        }
    }

    private void parseQuery(final String query) throws RecognitionException {
        parser = new QueryParser(query);
    }
}
