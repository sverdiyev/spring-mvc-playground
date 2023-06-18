package com.example.controller;

import com.example.model.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebsocketHandler extends TextWebSocketHandler {

  public MyWebsocketHandler() {
    System.out.println("hello from websocket handler");
  }

  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    var mapper = new ObjectMapper();

    ChatMessage receivedMessage = mapper.readValue(message.getPayload(), ChatMessage.class);
    System.out.println("message received");
    System.out.println(receivedMessage);

    session.sendMessage(new TextMessage("hello from api"));

    var resMessage = new ChatMessage("Sasha", "hello from sasha", new Timestamp(1000));

    var mappedRes = mapper.writeValueAsString(resMessage);

    session.sendMessage(new TextMessage(mappedRes));
  }

}
