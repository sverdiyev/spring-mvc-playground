package com.example.repository;


import com.example.model.ChatMessage;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
      SELECT id, username, message_content FROM test_table;
      """, (rs, rowNum) -> new ChatMessage(rs.getString("username"), rs.getString("message_content"), rs.getInt("id")));
  }


  public void addMessage(String username, String messageContent) {
    MapSqlParameterSource params = new MapSqlParameterSource()
      .addValue("userName", username)
      .addValue("messageContent", messageContent);

    namedParameterJdbcTemplate.update("""
      INSERT INTO test_table (username, message_content) values (:userName, :messageContent);
      """, params);
  }
}
