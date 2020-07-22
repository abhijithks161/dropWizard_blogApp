package com.dexlock.blogapp.services;

import com.dexlock.blogapp.configuration.BlogAppConfiguration;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import io.dropwizard.lifecycle.Managed;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoService implements Managed {

    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    public MongoDatabase getDB() {
        if (mongoDatabase == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            ServerAddress serverAddress = new ServerAddress(BlogAppConfiguration.getMongoHost(), BlogAppConfiguration.getMongoPort());
            MongoClientOptions clientOptions = MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build();
            mongoClient = new MongoClient(serverAddress, clientOptions);
            mongoDatabase = mongoClient.getDatabase(BlogAppConfiguration.getMongoDBName());
        }
        return mongoDatabase;
    }


    public void start() throws Exception {
        getDB();
    }

    public void stop() throws Exception {
        mongoClient.close();
    }
}
