package com.example.config;

import com.example.controller.MyWebsocketHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example")
@EnableWebSocket
public class MyWebConfig implements WebMvcConfigurer, WebSocketConfigurer {

  public MyWebConfig() {
    System.out.println("HELLO FROM CONFIG");
  }


  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
  }

  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(new MyWebsocketHandler(), "/chat").setAllowedOrigins("*");
  }

}
