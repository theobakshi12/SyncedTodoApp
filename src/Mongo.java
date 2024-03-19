import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection collection;

    public Mongo() {
        client = MongoClients.create("mongodb+srv://theobakshi12:PotatoClient12!@syncednotescluster.qcov4za.mongodb.net/?retryWrites=true&w=majority&appName=SyncedNotesCluster");

        database = client.getDatabase("notesDB");

        collection = database.getCollection("notesCollection");
    }

    public MongoCollection getCollection() {
        return collection;
    }
}
