package com.wy.SpikeShopping.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {


    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    protected String databaseName;

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create(uri);
    }

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }
//    @Value("${spring.data.mongodb.uri}")
//    private String mongoUri;
//
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;

//    @Bean
//    public MongoClient mongoClient() {
//        MongoDBConfig
//        MongoClientURI uri = new MongoClientURI(mongoUri);
//        return ;
//    }

//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongoClient(), databaseName);
//    }
}
