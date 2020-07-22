package com.dexlock.blogapp;

import com.dexlock.blogapp.configuration.BlogAppConfiguration;
import com.dexlock.blogapp.resources.UserResource;
import com.dexlock.blogapp.services.MongoService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class MainApp extends Application<BlogAppConfiguration> {


    public static void main(String[] args) throws Exception {
        new MainApp().run("server", "conf.yml");
    }

    public void run(BlogAppConfiguration blogAppConfiguration, Environment environment) throws Exception {
        environment.lifecycle().manage(new MongoService());
        environment.jersey().register(new UserResource());
    }
}
