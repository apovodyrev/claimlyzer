package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 6/6/17
 */
public class Example2 {
//    private static Logger log = Logger.getLogger(Example2.class);

    public static void main(String [] args){

        //Setup
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("restaurants");



        List<Document> boroughs = collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("cuisine", "Bakery")),
                        Aggregates.group("$borough", Accumulators.sum("count", 1))
                )
        ).into(new ArrayList<Document>());

        for(Document d:boroughs){
            System.out.println(d);
        }



        // Into List (using filter)
        List<Document> restaurants = collection.find(
                new Document("borough", "Bronx").append("cuisine", "Bakery") //Filter Bakeries in bronx
        ).into(new ArrayList<Document>());

        System.out.println(restaurants.size());

    }
}
