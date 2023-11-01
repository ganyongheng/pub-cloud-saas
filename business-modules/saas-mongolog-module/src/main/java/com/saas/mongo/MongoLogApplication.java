package com.saas.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.saas.mongo.repository"})
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MongoLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoLogApplication.class, args);
    }

}
