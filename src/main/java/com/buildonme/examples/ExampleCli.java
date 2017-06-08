package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 6/7/17.
 */
public class ExampleCli {
    public static void main(String [] args){

        //Constants
        final String DATABASE_NAME = "test";
        final String COLLECTION_NAME = "restaurants";

        //Setup, connect to DB
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Scanner scan = new Scanner(System.in);

        String key, value, more;
        boolean done = false;
        Document filters = new Document();



//        // Get filters from user
//        while (!done){
//            System.out.println("Enter a Key");
//            key = scan.next();
//
//            System.out.println("Enter a Value");
//            value = scan.next();
//
//            filters.append(key, value); // Append to the filters JSON document
//
//            System.out.println("More? (y or n)");
//            more = scan.next();
//            if (more.equals("n"))
//                done = true;
//
//        }

        //Temp values
        filters.append("borough", "Manhattan");
        filters.append("cuisine", "Bakery");

        System.out.println();

        // Fill list of restaurants thru filter
        List<Document> restaurants = collection.find(filters).into(new ArrayList<Document>());

        System.out.println("Results: " + String.valueOf(restaurants.size()) + "\n");


//        //Listing results
//        done = false;
//        String field;
//        while (!done){
//            System.out.println("By what field do you want to list your results by?");
//            field = scan.next();
//
//            for (Document d : restaurants)
//                System.out.println( d.getString(field) );
//
//        }



        //List what keys are in a document
        Document first = restaurants.get(0);

        System.out.println(first.size());

        System.out.println(first.keySet());





    }
}
