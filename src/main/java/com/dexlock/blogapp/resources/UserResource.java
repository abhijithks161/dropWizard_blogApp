package com.dexlock.blogapp.resources;

import com.dexlock.blogapp.dao.UserDAO;
import com.dexlock.blogapp.models.User;
import org.bson.types.ObjectId;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    private UserDAO userDAO = new UserDAO();


    @PUT
    public Response createUser(@Valid User user) {
        userDAO.create(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("all")
    public Response fetchAllUsers() {
        List<User> users = userDAO.fetchAll();
        return Response.ok().entity(users).build();
    }

    @GET
    public Response readUser(@QueryParam("id") String id) {
        User user = userDAO.fetchUser(id);
        return Response.ok(user).build();
    }

    @DELETE
    public Response deleteUser(@QueryParam("id") ObjectId id) {

        boolean delStatus = userDAO.deleteUser(id);
        return Response.ok().entity(delStatus).build();
    }

}
