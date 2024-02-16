package ETbwz.Kunde;

import ETbwz.Computer.Computer;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.util.Iterator;
import java.util.List;

public class KundeRepository implements IKundeRepository {

    public List<Kunde> getAll() {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("KundeDb");

        FindIterable<Document> iterDoc=collection.find();
        int i=1;

        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }

        return null;
    }


    public Kunde getById(String KundeId) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("KundeDb");
        FindIterable<Document> iterDoc=collection.find(Filters.eq("_id", new ObjectId(KundeId)));
        int i=1;

        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }


        return  null;
    }

    public void insert(Kunde kunde) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("KundeDb");


        Document document = new Document("Nachname", kunde.getNachname())
                .append("Vorname", kunde.getVorname())
                .append("Geschlecht", kunde.getGender())
                .append("Geburtsdatum", kunde.getGeburtsdatum())
                .append("Sprache", kunde.getSprache())
                .append("Email", kunde.getEmail())
                .append("Telefon", kunde.getTelefon())
                .append("Adresse", new Document()
                        .append("Strasse", kunde.getAdresse().getStrasse())
                        .append("PLZ", kunde.getAdresse().getPlz())
                        .append("Ort", kunde.getAdresse().getOrt()));

        collection.insertOne(document);
        System.out.println("Kunde wurde erfolgreich hinzugefügt.");
    }

    public void update(Kunde kunde, String KundeId) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("KundeDb");


        Document document = new Document("Nachname", kunde.getNachname())
                .append("Vorname", kunde.getVorname())
                .append("Geschlecht", kunde.getGender())
                .append("Geburtsdatum", kunde.getGeburtsdatum())
                .append("Sprache", kunde.getSprache())
                .append("Email", kunde.getEmail())
                .append("Telefon", kunde.getTelefon())
                .append("Adresse", new Document()
                        .append("Strasse", kunde.getAdresse().getStrasse())
                        .append("PLZ", kunde.getAdresse().getPlz())
                        .append("Ort", kunde.getAdresse().getOrt()));

        collection.replaceOne(
                Filters.eq("_id", new ObjectId(KundeId)), document
        );
    }

    public void delete(String KundeId) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        MongoCollection<Document> collection = database.getCollection("KundeDb");
        Bson filter = Filters.eq("_id", new ObjectId(KundeId));
        collection.deleteOne(filter);
    }


}
