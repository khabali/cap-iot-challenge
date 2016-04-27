package com.khabali.capdevchallenge;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("messages")
public class MessageService {

	@Resource(name = MessageEmbededDao.BEAN_ID)
	private MessageDao messageDao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response messagePost(Message message) {

		messageDao.insertMessage(message);
		return Response.ok().build();
	}

}
