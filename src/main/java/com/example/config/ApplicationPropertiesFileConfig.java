package com.example.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@PropertySource("classpath:application.yml")
public class ApplicationPropertiesFileConfig {


  @Bean
  //needs to be static to allow spring context to resolve the application files early enough
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

    var properties = new PropertySourcesPlaceholderConfigurer();

    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource("application.yml"));

    properties.setProperties(yaml.getObject());

    return properties;
  }

}
