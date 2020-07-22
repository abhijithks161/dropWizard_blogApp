package com.dexlock.blogapp.configuration;

import io.dropwizard.Configuration;

public class BlogAppConfiguration extends Configuration {
    private static String mongoHost;
    private static Integer mongoPort;
    private static String mongoDBName;


    public static String getMongoHost() {
        return mongoHost;
    }

    public void setMongoHost(String mongoHost) {
        BlogAppConfiguration.mongoHost = mongoHost;
    }

    public static Integer getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(Integer mongoPort) {
        BlogAppConfiguration.mongoPort = mongoPort;
    }

    public static String getMongoDBName() {
        return mongoDBName;
    }

    public void setMongoDBName(String mongoDBName) {
        BlogAppConfiguration.mongoDBName = mongoDBName;
    }
}
