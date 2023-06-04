import org.hsqldb.Server;

public class DBLauncher {

    public static void main(String[] args) {
        System.out.println("Starting Database");
        Server server = new Server();
        server.setDatabasePath(0, "~/transactions.db");
        server.setDatabaseName(0, "transactions");
        server.start();
    }
}
