import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Backend {

    Mongo mongo;
    MongoCollection col;

    public Backend() {
        mongo = new Mongo();
        col = mongo.getCollection();
    }

    public void save(String user, String content) {
        if (col.countDocuments(new Document("_id", user)) > 0) { //update current doc
            col.updateOne(new Document("_id", user),
                    new Document("$set", new Document("content", content)));
        } else { //create doc because one doesn't exist yet for user
            col.insertOne(new Document("_id", user).append("content", content));
        }
    }

    public String getContent(String user) {
        Document doc = (Document) col.find(new Document("_id", user)).first();
        if (doc != null) {
            return doc.get("content").toString();
        } else {
            System.out.println("no data for given user exists");
            return null;
        }
    }

    public void login() {

    }
}
