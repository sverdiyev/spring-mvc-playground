package com.example.controller;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends HttpFilter {


  public MyFilter() {
    System.out.println("hello from my filter");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException {
    System.out.println("filter - before");

    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("filter - after");
  }
}
