package com.dexlock.blogapp.dao;

import com.dexlock.blogapp.constants.CollectionNames;
import com.dexlock.blogapp.models.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAO extends BaseDAO<User> {

    public MongoCollection<User> getCollection() {
        return mongoService.getDB().getCollection(CollectionNames.USER_COLL, User.class);
    }

    public void create(User object) {
        object.setCreatedDate(new Date());
        getCollection().insertOne(object);
    }

    public List<User> fetchAll() {
        List<User> users = new ArrayList<User>();
        FindIterable<User> userFindIterable = getCollection().find();
        userFindIterable.into(users);
        return users;
    }

    public User fetchUser(String userId) {
        Document document = new Document();
        document.put("_id", new ObjectId(userId));
        return getCollection().find(document).first();
    }

    public boolean deleteUser(ObjectId userId) {
        Document document = new Document("_id", userId);
        DeleteResult deleteResult = getCollection().deleteOne(document);
        if (deleteResult.getDeletedCount() > 0) {
            return true;
        } else {
            return false;
        }

    }
}
