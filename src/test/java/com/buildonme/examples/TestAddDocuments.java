package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 6/8/17.
 * Adds documents to a collection from program
 * Can create new database and collection
 */
public class TestAddDocuments {
    public static void main(String [] args) {

        //Constants
        final String DATABASE_NAME = "test2";
        final String COLLECTION_NAME = "cars";

        //Setup, connect to DB
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Scanner scan = new Scanner(System.in);

        // Insert document
        collection.insertOne(new Document("make: ", "Mazda").append("model", "Miata"));

        //Import all Documents
        List<Document> cars = collection.find().into(new ArrayList<Document>());

        //List them
        for (Document d : cars){
            System.out.println(d);
        }

        //Delete db
        database.drop();










    }
}
