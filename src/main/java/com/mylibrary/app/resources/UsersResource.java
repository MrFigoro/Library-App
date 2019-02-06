package com.mylibrary.app.resources;

import com.mylibrary.app.api.User;
import com.mylibrary.app.core.UserService;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    private UserService userService = null;

    public UsersResource(UserService userService) {
           this.userService = userService;
    }

    @POST
    public Response createUser(User user) {
        if ((user.getFirstName().length() == 0) | (user.getFirstName().length() > 40)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else if ((user.getLastName().length() == 0) | (user.getLastName().length() > 80)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            user = userService.createUser(user);
            return Response.status(Response.Status.CREATED).entity(user).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response putUser(User user, @PathParam("id") String id) {
        User itUser = userService.getUser(id);
        if (itUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else if ((user.getFirstName().length() == 0) | (user.getFirstName().length() > 40)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else if ((user.getLastName().length() == 0) | (user.getLastName().length() > 80)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            user = userService.putUser(user, id);
            return Response.status(Response.Status.OK).entity(user).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") String id) {
        User itUser = userService.getUser(id);
        if (itUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            return Response.status(Response.Status.OK).entity(userService.getUser(id)).build();
        }
    }


    @GET
    public Response getUsers(User user) {
        return Response.status(Response.Status.OK).entity(userService.getUsers()).build();
    }



//    @GET
//    @Timed
//    public Showing sayHello(@QueryParam("name") String name) {
//        final String value = String.format(template, (name == null || name.equals("")) ?
//                          defaultName : name);
//        return new Showing(counter.incrementAndGet(), value);
//    }

//    @GET
//    @Path("/something")
//    @Timed
//    public String sayHello() {
//        return "Any string";
//    }



//    private final NotificationStore store;
//
//    public NotificationsResource(NotificationStore store) {
//        this.store = store;
//    }

//    @GET
//    public NotificationList fetch(@PathParam("user") LongParam userId,
//                                  @QueryParam("count") @DefaultValue("20") IntParam count) {
//        final List<Notification> notifications = store.fetch(userId.get(), count.get());
//        if (notifications != null) {
//            return new NotificationList(userId, notifications);
//        }
//        throw new WebApplicationException(Status.NOT_FOUND);
//    }

//    @POST
//    public Response add(@PathParam("user") LongParam userId,
//                        @NotNull @Valid Notification notification) {
//        final long id = store.add(userId.get(), notification);
//        return Response.created(UriBuilder.fromResource(NotificationResource.class)
//                .build(userId.get(), id))
//                .build();
//    }
}
