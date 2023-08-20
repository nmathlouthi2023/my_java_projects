package com.db.mongosql;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MongoSqlApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MongoSqlApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("Started ...................");
        SpringApplication springApplication = new SpringApplication((MongoSqlApplication.class));
        springApplication.run(args);
    }

}
