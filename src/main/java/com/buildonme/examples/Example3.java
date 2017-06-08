package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 6/7/17.
 */
public class Example3 {
    public static void main(String [] args){

        //Constants
        final String DATABASE_NAME = "test";
        final String COLLECTION_NAME = "cars";

        //Setup, connect to DB
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Scanner scan = new Scanner(System.in);


        List<Document> makes = collection.aggregate(
                Arrays.asList(
//                        Aggregates.match(new Document("cuisine", "Bakery")),
                        Aggregates.group("$make", Accumulators.sum("count", 1))
                )
        ).into(new ArrayList<Document>());


        for (Document d : makes)
            System.out.println(d);





    }
}
