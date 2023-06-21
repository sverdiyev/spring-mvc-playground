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
  @Value("${local-url}")
  private String localDbConnectionUrl;
  @Value("${aws-url}")
  private String awsDbConnectionUrl;

  @Bean
  public DataSource postgresDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUsername("postgres");
    dataSource.setPassword("postgres");

    dataSource.setUrl(activeProfile.equalsIgnoreCase("aws") ? awsDbConnectionUrl : localDbConnectionUrl);

    return dataSource;
  }

  @Bean
  public NamedParameterJdbcTemplate template(DataSource source) {
    return new NamedParameterJdbcTemplate(source);
  }

}
