package com.capgemini.ito.spark.config;

import static spark.Spark.get;
import static spark.Spark.post;

import com.capgemini.ito.spark.model.Message;
import com.capgemini.ito.spark.model.Synthesis;
import com.capgemini.ito.spark.service.impl.MessageService;
import com.capgemini.ito.spark.transformer.JsonTransformer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WebConfig {

	// thread config
	private static final int maxThreads = -1;
	private static final int minThreads = 40;
	private static final int idleTimeoutMillis = 60000;
	private static final int HTTP_BAD_REQUEST = 400;
	private static final int HTTP_OK_REQUEST = 200;

	// java service
	private MessageService service;
	private ObjectMapper mapper;

	public WebConfig(MessageService service) {
		this.service = service;
		this.mapper = new ObjectMapper();
		spark.SparkBase.threadPool(maxThreads, minThreads, idleTimeoutMillis);
		setupRoutes();
		spark.SparkBase.awaitInitialization();
	}

	private void setupRoutes() {

		/**
		 * Create a new message
		 */
		post("/messages", (req, res) -> {

			try {
				Message newMessage = mapper.readValue(req.body(), Message.class);
				if (!newMessage.isValid()) {
					res.status(HTTP_BAD_REQUEST);
					return res;
				}
				service.messagePost(newMessage);
				res.status(HTTP_OK_REQUEST);
				return res;
			} catch (JsonParseException e) {
				res.status(HTTP_BAD_REQUEST);
				return res;
			}
		});

		/**
		 * 
		 */
		get("/messages/syntesis", (request, response) -> {
			return new Synthesis(1, 12l, 12l, 12L);
		} , new JsonTransformer());

	}

}
