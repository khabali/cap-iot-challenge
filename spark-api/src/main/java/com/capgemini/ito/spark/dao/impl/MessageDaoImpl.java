package com.capgemini.ito.spark.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.ito.spark.dao.MessageDao;
import com.capgemini.ito.spark.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	private NamedParameterJdbcTemplate template;

	@Autowired
	public MessageDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public void insertMessage(Message m) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", m.getId());
		params.put("SensorType", m.getSensorType());
		params.put("creationDate", m.getTimestamp());
		params.put("value", m.getValue());

		String sql = "insert into message (id, SensorType, creationDate, value) values (:id, :SensorType, :creationDate, :value)";
		template.update(sql, params);
	}

	private RowMapper<Message> messageMapper = (rs, rowNum) -> {

		Message m = new Message();
		m.setId(rs.getString("id"));
		m.setSensorType(rs.getInt("SensorType"));
		m.setTimestamp(rs.getTimestamp("creationDate"));
		m.setValue(rs.getLong("value"));

		return m;
	};

}
