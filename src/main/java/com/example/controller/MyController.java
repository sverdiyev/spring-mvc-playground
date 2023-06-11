package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @GetMapping(value = "/elo", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Map<String, String> hello() {
    HashMap<String, String> response = new HashMap<>();
    response.put("message", "Hello from controller");
    return response;
  }

  @GetMapping("/foo")
  @ResponseBody
  public String foo() {
    return "foo";
  }

}
