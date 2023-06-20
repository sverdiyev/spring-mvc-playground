package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ChatMessage(
  @JsonProperty("userName") String userName,
  @JsonProperty("messageContent") String messageContent,
  @JsonProperty("id") int id
//  @JsonProperty("time") Timestamp time
) {

}
