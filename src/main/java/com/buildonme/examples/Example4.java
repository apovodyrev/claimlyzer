package com.buildonme.examples;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 6/7/17.
 */
public class Example4 {
    public static void main(String [] args){

        //Constants
        final String DATABASE_NAME = "test";
        final String COLLECTION_NAME = "cars";

        //Setup, connect to DB
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Scanner scan = new Scanner(System.in);

        List<Document> cars = collection.find().into(new ArrayList<Document>());

        String choice;
        while(true){
            System.out.println("What would you like to do? (view, add):");
            choice = scan.next();

            if (choice.equals("view")){

                for ( Document d : cars)
                    System.out.println(d);

            }else if (choice.equals("add")){




            }



        }








    }
}
