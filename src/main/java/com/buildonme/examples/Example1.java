package com.buildonme.examples;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Alex on 6/5/17
 */
public class Example1 {
//    private static Logger log = Logger.getLogger(Example1.class);

    public static void main(String [] args){

        //Setup
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("restaurants");


//        System.out.println(collection.find().limit(2));
//        System.out.println(collection.find().first());

//        FindIterable results = collection.find().limit(2);
//        results.forEach(new Block() {
//            @Override
//            public void apply(Object o) {
//                System.out.println(o);
//            }
//        });
//
//        Document myDoc = collection.find().first();
//        System.out.println(myDoc);



        // Puts all documents into array
        List<Document> restaurants = collection.find().into(new ArrayList<Document>());
//        for (Iterator<Document> iterator = restaurants.iterator(); iterator.hasNext(); ) {
//            Document next =  iterator.next();
//
//        }


        List<String> boroughs = new ArrayList<String>();
        for(Document d:restaurants){

//            if ( d.getString("borough").equals("Manhattan") )
//                System.out.println(d.getString("borough") );
//            System.out.println(d.getString("borough") );

            String borough = d.getString("borough");

            if (!boroughs.contains(borough))
                boroughs.add(borough);
        }

        System.out.println(boroughs);







        Document firstResult = restaurants.get(0); // First document
        Set keys = firstResult.keySet(); // Keys of the document
        Collection values = firstResult.values(); //Values

//        System.out.print("Keys: ");
//        System.out.println(keys);
//
//        System.out.print("Values: ");
//        System.out.println(values);

//        System.out.println(firstResult.get("Borough"));



    }
}
