package com.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext servletContext) {

    var rootCtx = new AnnotationConfigWebApplicationContext();

    rootCtx.register(MyWebConfig.class);

    // Creating a dispatcher servlet object
    var dispatcherServlet = new DispatcherServlet(rootCtx);

    // Registering Dispatcher Servlet with Servlet
    // Context
    ServletRegistration.Dynamic myCustomDispatcherServlet =
      servletContext.addServlet("myDispatcherServlet", dispatcherServlet);

    // Setting load on startup
    myCustomDispatcherServlet.setLoadOnStartup(1);

    // Adding mapping url
    myCustomDispatcherServlet.addMapping("/");
  }
}
