package ETbwz;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        // 2. Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("Enes", "ComputerShopDb",
                "password".toCharArray());

        System.out.println("Connected to the database successfully");

        // 3. Accessing the database
        MongoDatabase database = mongoClient.getDatabase("ComputerShopDb");
        System.out.println("Credentials ::" + credential);

        // 4. Creating a collection
        // database.createCollection("sampleCollection");
        // System.out.println("Collection created successfully");

        // 5. List Databases
        List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());

        System.out.println("All databases:");
        databases.forEach(db -> System.out.println(db));

        database.createCollection("ComputerDb");
        System.out.println("Collection created successfully");







    }
}