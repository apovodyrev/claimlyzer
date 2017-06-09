package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 6/9/17.
 */
public class TestFilters {
    private static Logger log = Logger.getLogger(TestFilters.class);

    public static void main(String [] args) {

        //Setup
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("restaurants");

        Bson filters = and(
                eq("borough", "Manhattan"),
                eq("cuisine", "Bakery")
        );

        Bson filters1 = and(
                in("borough", "Manhattan", "Bronx", "Queens"),
                nin("cuisine", "Bakery"),
                gte("grades.score", 90)

        );

        // Import
        List<Document> collectionList = collection.find( filters1 ).into(new ArrayList<Document>());

        // Show count
        log.info("Count: " + String.valueOf(collectionList.size()) + "\n");

        //List
        for (Document d : collectionList){

            for (Object o : d.values()){
                log.info(o);
            }
            log.info("\n");




        }







    }
}
