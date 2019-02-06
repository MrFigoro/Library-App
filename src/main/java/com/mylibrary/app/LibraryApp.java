package com.mylibrary.app;

import com.mylibrary.app.core.UserService;
import com.mylibrary.app.resources.UsersResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello library!
 *
 */
public class LibraryApp extends Application<LibraryAppConfig>
{
    public static void main(String[] args) throws Exception {
        new LibraryApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-library";
    }

    @Override
    public void initialize(Bootstrap<LibraryAppConfig> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(LibraryAppConfig configuration,
                    Environment environment) {
//        final HelloLibraryResource resource = new HelloLibraryResource(
//                configuration.getTemplate(),
//                configuration.getDefaultName()
//        );
        final UsersResource resource = new UsersResource(
                new UserService()
        );
        environment.jersey().register(resource);
    }

}
