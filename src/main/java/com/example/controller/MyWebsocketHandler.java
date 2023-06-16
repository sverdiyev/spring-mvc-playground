package com.example.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebsocketHandler extends TextWebSocketHandler {

  public MyWebsocketHandler() {
    System.out.println("hello from websocket handler");
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    System.out.println("message received");
    System.out.println(message.getPayload());
  }


}
