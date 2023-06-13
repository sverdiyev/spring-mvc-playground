package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


  public MyController() {
    System.out.println("hello from controller bean");
  }

  @GetMapping(value = "/elo")
  public Map<String, String> hello() {
    HashMap<String, String> response = new HashMap<>();
    response.put("message", "Hello from controller");
    return response;
  }

  @GetMapping("/foo")
  public String foo() {
    return "foo";
  }

}
