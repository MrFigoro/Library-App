package com.mylibrary.app.resources;

import com.codahale.metrics.annotation.Timed;
import com.mylibrary.app.api.Saying;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class HelloLibraryResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloLibraryResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @POST

    @Timed
    public Saying sayHello(@QueryParam("name") String name) {
        final String value = String.format(template, (name == null || name.equals("")) ? defaultName : name);
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Path("/something")
    @Timed
    public String sayHello() {
        return "Any string";
    }
}
