package com.khabali.capdevchallenge;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository(MessageEmbededDao.BEAN_ID)
public class MessageEmbededDao implements MessageDao {

	public static final String BEAN_ID = "MessageEmbededDao";

	@Resource(name = "jdbcTemplate")
	private NamedParameterJdbcTemplate template;

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
