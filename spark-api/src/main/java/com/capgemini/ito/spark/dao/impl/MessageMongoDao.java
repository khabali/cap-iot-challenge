package com.capgemini.ito.spark.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.ito.spark.dao.MessageDao;
import com.capgemini.ito.spark.model.Message;

@Repository(MessageMongoDao.BEAN_ID)
public class MessageMongoDao implements MessageDao {

	public static final String BEAN_ID = "MessageMongoDao";

	private MongoTemplate mongoTemplate;

	@Autowired
	public MessageMongoDao(MongoDbFactory mongoDbFactory) {
		mongoTemplate = new MongoTemplate(mongoDbFactory);
	}

	@Override
	public void insertMessage(Message m) {

		mongoTemplate.save(m);

	}

}
