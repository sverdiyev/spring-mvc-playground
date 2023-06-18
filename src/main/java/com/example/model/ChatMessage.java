package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;

public record ChatMessage(
  @JsonProperty("userName") String userName,
  @JsonProperty("messageContent") String messageContent,
  @JsonProperty("time") Timestamp time
) {

}
