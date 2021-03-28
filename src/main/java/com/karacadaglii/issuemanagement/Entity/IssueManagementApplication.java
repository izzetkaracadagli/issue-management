package com.karacadaglii.issuemanagement.Entity;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class IssueManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(IssueManagementApplication.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
