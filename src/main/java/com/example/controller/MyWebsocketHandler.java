package com.example.controller;

import com.example.model.ChatMessage;
import com.example.repository.ChatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebsocketHandler extends TextWebSocketHandler {

  private final ChatRepository chatRepository;

  public MyWebsocketHandler(ChatRepository chatRepository) {
    System.out.println("hello from websocket handler");
    this.chatRepository = chatRepository;
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

    List<ChatMessage> messages = chatRepository.getAll();

    for (ChatMessage msg : messages) {

      var mappedMsg = mapper.writeValueAsString(msg);
      session.sendMessage(new TextMessage(mappedMsg));
    }

  }

}
