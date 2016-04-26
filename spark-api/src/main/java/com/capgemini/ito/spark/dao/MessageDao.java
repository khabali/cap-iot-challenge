package com.capgemini.ito.spark.dao;

import com.capgemini.ito.spark.model.Message;

public interface MessageDao {

	void insertMessage(Message m);
}
