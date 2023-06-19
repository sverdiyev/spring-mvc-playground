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

  private final ObjectMapper mapper = new ObjectMapper();

  public MyWebsocketHandler(ChatRepository chatRepository) {
    System.out.println("hello from websocket handler");
    this.chatRepository = chatRepository;
  }


  @Override
  protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

    ChatMessage receivedMessage = mapper.readValue(message.getPayload(), ChatMessage.class);

    chatRepository.addMessage("anon", receivedMessage.messageContent());

    var resMessage = new ChatMessage("Sasha", "hello from sasha", new Timestamp(1000));

    var mappedRes = mapper.writeValueAsString(resMessage);

    session.sendMessage(new TextMessage(mappedRes));

    List<ChatMessage> messages = chatRepository.getAll();

    for (ChatMessage msg : messages) {

      var mappedMsg = mapper.writeValueAsString(msg);
      session.sendMessage(new TextMessage(mappedMsg));
    }

  }

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {

    var messages = chatRepository.getAll();

    for (ChatMessage msg : messages) {
      session.sendMessage(new TextMessage(mapper.writeValueAsString(msg)));
    }

  }
}
