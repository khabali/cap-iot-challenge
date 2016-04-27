package com.capgemini.ito.spark.config;

import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {

		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2).addScript("sql/create-db.sql").build();
		return db;
	}

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {

		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"),
				new MongoClientOptions.Builder().socketKeepAlive(true).minConnectionsPerHost(15).build());
		return new SimpleMongoDbFactory(mongoClient, "database");
	}

}
