package com.example.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

  @Bean
  public DataSource postgresDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/testing_db");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");

    return dataSource;
  }


  @Bean
  public NamedParameterJdbcTemplate template(DataSource source) {
    return new NamedParameterJdbcTemplate(source);
  }

}
