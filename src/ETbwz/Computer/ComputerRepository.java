package ETbwz.Computer;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Iterator;
import java.util.List;


public class ComputerRepository implements IComputerRepository {

    public List<Computer> getAll() {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("ComputerDb");


        FindIterable<Document> iterDoc=collection.find();
        int i=1;

        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }

    return null;
    }


    public Computer getById(String ComputerId) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("ComputerDb");

        FindIterable<Document> iterDoc=collection.find(Filters.eq("_id", new ObjectId(ComputerId)));
        int i=1;



        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }

        Document doc = collection.find(Filters.eq("_id", new ObjectId(ComputerId))).first();
        if (doc != null) {
            String hersteller = doc.getString("Hersteller");
            String modell = doc.getString("Modell");
            double arbeitsspeicher = doc.getDouble("Arbeitsspeicher [GB]");
            String cpu = doc.getString("CPU");
            double massenspeicher = doc.getDouble("Massenspeicher [GB]");
            String typ = doc.getString("Typ");
            double einzelpreis = doc.getDouble("Einzelpreis");

            return new Computer(hersteller, modell, arbeitsspeicher, cpu, massenspeicher, typ, einzelpreis);
        } else {
            System.out.println("Computer mit der angegebenen ID wurde nicht gefunden.");
        }
        return null;

    }

    public void insert(Computer computer) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("ComputerDb");


        Document document=new Document("Modell", computer.getModell())
                .append("Hersteller",computer.getHersteller())
                .append("Arbeitsspeicher [GB]", computer.getArbeitsspeicher())
                .append("CPU",computer.getCpu())
                .append("Massenspeicher [GB]", computer.getMassenspeicher())
                .append("Typ", computer.getTyp())
                .append("Einzelpreis", computer.getEinzelpreis());

        collection.insertOne(document);
        System.out.println("Computer wurde erfolgreich hinzugefügt.");

    }

    public void update(Computer computer, String ComputerId) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("ComputerDb");


        Document document=new Document("Modell", computer.getModell())
                .append("Hersteller",computer.getHersteller())
                .append("Arbeitsspeicher [GB]", computer.getArbeitsspeicher())
                .append("CPU",computer.getCpu())
                .append("Massenspeicher [GB]", computer.getMassenspeicher())
                .append("Typ", computer.getTyp())
                .append("Einzelpreis", computer.getEinzelpreis());

        collection.replaceOne(
            Filters.eq("_id", new ObjectId(ComputerId)), document
        );
    }

    public void delete(String ComputerId) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        MongoCollection<Document> collection = database.getCollection("ComputerDb");
        Bson filter = Filters.eq("_id", new ObjectId(ComputerId));
        collection.deleteOne(filter);
    }

    public String getModellById(String ComputerId) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        MongoCollection<Document> collection = database.getCollection("ComputerDb");

        FindIterable<Document> iterDoc = collection.find(Filters.eq("_id", new ObjectId(ComputerId)));
        Iterator it = iterDoc.iterator();

        String modell = null;
        if (it.hasNext()) {
            Document doc = (Document) it.next();
            modell = doc.getString("Modell");

        }

        return modell;
    }


}
