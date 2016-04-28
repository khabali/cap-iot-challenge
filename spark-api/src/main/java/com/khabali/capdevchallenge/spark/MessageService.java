package com.khabali.capdevchallenge.spark;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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
