package com.teste.springbootconfig.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String testDatabaseConnection(){
        System.out.println("DB CONNECTION FOR DEV");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB CONNECTION TO H2- TEST INSTANCE";
    }

    @Profile("prod")
    @Bean
    public String prodDatabaseConnection(){
        System.out.println("DB CONNECTION FOR PROD");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB CONNECTION TO MYSQL_PROD - PROD INSTANCE";
    }
}
