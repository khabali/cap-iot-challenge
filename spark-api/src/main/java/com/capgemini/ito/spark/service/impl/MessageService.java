package com.capgemini.ito.spark.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.capgemini.ito.spark.dao.MessageDao;
import com.capgemini.ito.spark.dao.impl.MessageEmbededDao;
import com.capgemini.ito.spark.model.Message;

@Service
public class MessageService {

	@Resource(name = MessageEmbededDao.BEAN_ID)
	private MessageDao messageDao;

//	@Resource(name = MessageMongoDao.BEAN_ID)
//	private MessageDao mongoMessageDao;

	public void messagePost(Message message) {
		messageDao.insertMessage(message);
		//mongoMessageDao.insertMessage(message);
	}

}
