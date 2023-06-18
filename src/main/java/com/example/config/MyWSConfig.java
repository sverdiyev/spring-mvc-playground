package com.example.config;

import com.example.controller.MyWebsocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class MyWSConfig implements WebSocketConfigurer {

  private final MyWebsocketHandler wsHandler;

  public MyWSConfig(MyWebsocketHandler wsHandler) {
    System.out.println("HELLO FROM WS CONFIG");
    this.wsHandler = wsHandler;
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(wsHandler, "/chat").setAllowedOrigins("*");
  }

}
