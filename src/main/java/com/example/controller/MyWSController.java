package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MyWSController {


  public MyWSController() {
    System.out.println("hello from WS controller bean");
  }
  SimpMessagingTemplate
  @MessageMapping("/chat")
//  @SendTo("/topic/greetings")
  public String greeting(String message) {
//    Thread.sleep(1000); // simulated delay
    return ("Hello, from Backend");
  }

}