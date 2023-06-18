package com.example.repository;


import com.example.model.ChatMessage;
import java.util.List;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChatRepository {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


  public ChatRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
  }

  public List<ChatMessage> getAll() {

    return namedParameterJdbcTemplate.query("""
      SELECT * FROM test_table;
      """, (rs, rowNum) -> new ChatMessage(rs.getString("name"), "got it from db", null));

  }
}
