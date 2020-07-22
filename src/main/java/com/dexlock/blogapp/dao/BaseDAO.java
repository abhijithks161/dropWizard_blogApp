package com.dexlock.blogapp.dao;

import com.dexlock.blogapp.services.MongoService;
import com.mongodb.client.MongoCollection;

import java.util.List;

public abstract class BaseDAO<T> {
    protected static MongoService mongoService = new MongoService();

    public abstract MongoCollection<T> getCollection();

    public abstract void create(T object);

    public abstract List<T> fetchAll();

}
