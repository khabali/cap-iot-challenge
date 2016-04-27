package com.khabali.capdevchallenge;

import java.util.Date;

public class Message {

	private String id = null;
	private Date timestamp = null;
	private Integer sensorType = null;
	private Long value = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getSensorType() {
		return sensorType;
	}

	public void setSensorType(Integer sensorType) {
		this.sensorType = sensorType;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public boolean isValid() {
		return id != null && timestamp != null && sensorType != null && value != null;
	}
}
