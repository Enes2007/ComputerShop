package ETbwz.Computer;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ComputerRepository implements IComputerRepository {

    ArrayList<Computer> computers;

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


    return  null;
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

    public void save() {

    }

}
