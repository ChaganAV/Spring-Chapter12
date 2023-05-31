package com.example.Chapter12.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {
    @Value("${custom.datasource.url}")
    private String datasourceUrl;

    @Value("${custom.datasource.username}")
    private String datasourceUsername;
    @Value("${custom.datasource.password}")
    private String datasourcePassword;
    @Bean
    @Primary
    public DataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }
}
