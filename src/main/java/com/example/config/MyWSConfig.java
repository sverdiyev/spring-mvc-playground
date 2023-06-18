package com.example.config;

import com.example.controller.MyWebsocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class MyWSConfig implements WebSocketConfigurer {

  public MyWSConfig() {
    System.out.println("HELLO FROM WS CONFIG");
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(new MyWebsocketHandler(), "/chat").setAllowedOrigins("*");
  }

}
