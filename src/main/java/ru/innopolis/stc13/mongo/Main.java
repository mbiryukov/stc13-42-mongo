package ru.innopolis.stc13.mongo;

import com.mongodb.*;

import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("localhost", 27017);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

/*        List<String> dbs = mongoClient.getDatabaseNames();
        for (String db : dbs){
            System.out.println(db);
        }*/

/*        DB db = mongoClient.getDB("test");
        DBCollection table = db.getCollection("users");
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.putIfAbsent("name", "Tom");
        dbObject.putIfAbsent("age", 32);
        table.insert(dbObject);*/

        DB db = mongoClient.getDB("test");
        DBCollection table = db.getCollection("users");
        DBCursor result = table.find();
        while (result.hasNext()) {
            DBObject current = result.next();
            System.out.println(current.get("_id") + " " + current.get("name") +
                    " " + current.get("age"));
        }
    }
}
