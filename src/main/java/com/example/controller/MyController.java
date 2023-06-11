package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @RequestMapping("/")
  @ResponseBody
  public Map<String, String> helloWorld() {
    HashMap<String, String> response = new HashMap<>();
    response.put("message", "Hello World");
    return response;
  }
}
