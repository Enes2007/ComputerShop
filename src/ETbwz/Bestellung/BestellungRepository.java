package ETbwz.Bestellung;

import ETbwz.Computer.Computer;
import ETbwz.Computer.ComputerRepository;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BestellungRepository implements IBestellungRepository{

    public List<Computer> getAll() {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("BestellungDb");

        FindIterable<Document> iterDoc=collection.find();
        int i=1;

        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }

        return null;
    }

    public Computer getById(int bestellnummer) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("BestellungDb");


        FindIterable<Document> iterDoc=collection.find(Filters.eq("Bestellnummer", bestellnummer));
        int i=1;

        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
            i++;
        }
        return  null;
    }



    public void insert(Bestellung bestellung, String ComputerId, Bestellposition bestellposition) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("BestellungDb");

        ComputerRepository computerRepository = new ComputerRepository();
        Computer computer = computerRepository.getById(ComputerId);
        String computerModell = (computer.getHersteller() + " " + computer.getModell());
        double computerPreis = computer.getEinzelpreis();
        bestellposition.setPreis(computerPreis);
        double netto = bestellposition.getPreis() * bestellposition.getPieces();

        Document document=new Document("Bestellnummer", bestellung.getBestellnummer())
                .append("Bestelldatum",bestellung.getBestelldatum())
                .append("Bestellposition", new Document()
                        .append("Modell", computerModell)
                        .append("Stück", bestellposition.getPieces())
                        .append("Preis", computerPreis))
                .append("Total", netto);

        collection.insertOne(document);
        System.out.println("Bestellung wurde erfolgreich hinzugefügt.");

    }



    public void update(Bestellung bestellung, String ComputerId, Bestellposition bestellposition, int bestellnummer) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");

        MongoCollection<Document> collection=database.getCollection("BestellungDb");

        ComputerRepository computerRepository = new ComputerRepository();
        Computer computer = computerRepository.getById(ComputerId);
        String computerModell = (computer.getHersteller() + " " + computer.getModell());
        double computerPreis = computer.getEinzelpreis();
        bestellposition.setPreis(computerPreis);
        double netto = bestellposition.getPreis() * bestellposition.getPieces();

        Document document=new Document("Bestellnummer", bestellung.getBestellnummer())
                .append("Bestelldatum",bestellung.getBestelldatum())
                .append("Bestellposition", new Document()
                        .append("Modell", computerModell)
                        .append("Stück", bestellposition.getPieces())
                        .append("Preis", computerPreis))
                .append("Total", netto);

        Bson filter = Filters.eq("Bestellnummer", bestellnummer);

        collection.replaceOne(filter, document);
        System.out.println("Bestellung wurde erfolgreich aktualisiert.");
    }

    public void delete(int bestellnummer) {
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        MongoCollection<Document> collection = database.getCollection("BestellungDb");
        Bson filter = Filters.eq("Bestellnummer", bestellnummer);
        collection.deleteOne(filter);
    }

    public boolean exists(int bestellnummer) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        MongoCollection<Document> collection = database.getCollection("BestellungDb");

        Document doc = collection.find(Filters.eq("Bestellnummer", bestellnummer)).first();
        long count = collection.countDocuments(Filters.eq("Bestellnummer", bestellnummer));
        return count > 0;
    }

}
