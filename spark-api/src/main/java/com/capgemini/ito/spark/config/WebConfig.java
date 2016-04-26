package com.capgemini.ito.spark.config;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import com.capgemini.ito.spark.model.Message;
import com.capgemini.ito.spark.model.Synthesis;
import com.capgemini.ito.spark.service.impl.MessageService;
import com.capgemini.ito.spark.transformer.JsonTransformer;

public class WebConfig {

	private MessageService service;

	public WebConfig(MessageService service) {
		this.service = service;
		staticFileLocation("/public");
		setupRoutes();
	}

	private void setupRoutes() {

		/**
		 * Create a new message
		 */
		post("/messages", "application/json", (req, res) -> {
			MultiMap<String> params = new MultiMap<String>();
			UrlEncoded.decodeTo(req.body(), params, "UTF-8", -1);
			Message m = new Message();
			BeanUtils.populate(m, params);
			service.messagePost(m);
			return null;
		});

		/**
		 * 
		 */
		get("/messages/syntesis", "application/json", (request, response) -> {
			return new Synthesis(1, 12l, 12l, 12L);
		} , new JsonTransformer());

	}

}
