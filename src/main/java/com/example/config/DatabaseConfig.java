package com.example.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

  @Value("${spring.profiles.active}")
  private String activeProfile;
  @Value("${datasource.postgres.url}")
  private String dbConnectionUrl;

  @Bean
  public DataSource postgresDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/testing_db");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");

    getProperties();

    return dataSource;
  }

  public void getProperties() {
    System.out.println("Currently active profile - " + activeProfile);
    System.out.println("db_connection_url - " + dbConnectionUrl);
  }

  @Bean
  public NamedParameterJdbcTemplate template(DataSource source) {
    return new NamedParameterJdbcTemplate(source);
  }

}
