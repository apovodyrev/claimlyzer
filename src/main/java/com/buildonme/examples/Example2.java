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
import java.util.Scanner;

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






















        List<Document> boroughs1 = collection.aggregate(
                Arrays.asList(
//                        Aggregates.match(Filters.eq("cuisine", "Bakery")),
                        Aggregates.match(new Document("cuisine", "Bakery")),
                        Aggregates.group("$borough", Accumulators.sum("count", 1))
                )
        ).into(new ArrayList<Document>());

        for(Document d:boroughs1){
            System.out.println(d);
        }

        //List of bakeries
        List<Document> bakeries = collection.find( new Document("cuisine", "Bakery") ).into(new ArrayList<Document>());

        //List of bakeries in manhattan
        List<Document> bakeriesInManhattan = new ArrayList<Document>();

        // Populate bakeriesInManhattan
        int totalCount = 0;
        int manhattanCount = 0;

        for (Document d : bakeries){

            String borough = d.getString("borough");

            if (borough.equals("Manhattan")) {
                bakeriesInManhattan.add(d);
                manhattanCount++;
            }

            totalCount++;
        }

        // Print stats
        System.out.println("Went through " + String.valueOf(totalCount) + " records.");
        System.out.println("Added " + String.valueOf(manhattanCount));

















        //Filter Bakeries in bronx that have recieved a score above 50
        List<Document> restaurants1 = collection.find(

                new Document("borough", "Bronx")
                .append("cuisine", "Bakery")
                .append("grades.score", new Document("$gte", 50))

        ).into(new ArrayList<Document>());

        //System.out.println(restaurants1.size());

//        System.out.println(boroughs.get(0).getString("_id"));

//        List<List<Document>> boroughs = new ArrayList<List<Document>>();




//        List<Document> boroughs = new ArrayList<Document>();
//
//        for ( Document d : boroughs1){
//            String boroughName = d.getString("_id");
//            boroughs.add(  new Document( boroughName, new Document("1", 3) )  );
//        }
//
//        System.out.println(boroughs);












    }
}
