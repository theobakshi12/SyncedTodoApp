import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Mongo {

    public Mongo() {
        MongoClient client = MongoClients.create("mongodb+srv://theobakshi12:PotatoClient12!@syncednotescluster.qcov4za.mongodb.net/?retryWrites=true&w=majority&appName=SyncedNotesCluster");

        MongoDatabase db = client.getDatabase("notesDB");

        MongoCollection col = db.getCollection("notesCollection");

        Document notesDoc = new Document("id", 1).append("note", 1);

        col.insertOne(notesDoc);
    }


}
