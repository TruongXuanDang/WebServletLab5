package com.demo.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class MyApp extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
