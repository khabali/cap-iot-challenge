package com.capgemini.ito.spark.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ito.spark.dao.MessageDao;
import com.capgemini.ito.spark.model.Message;

@Service
public class MessageService {

	@Autowired
	MessageDao messageDao;

	public void messagePost(Message message) {
		messageDao.insertMessage(message);
	}

}
