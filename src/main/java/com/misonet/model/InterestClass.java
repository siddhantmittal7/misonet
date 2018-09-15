package com.misonet.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interestCollection")
public class InterestClass {
	
	@Id
	String id;
	String interestName;
	List<String> eventIds;
	List<String> userIds;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInterestName() {
		return interestName;
	}
	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	public List<String> getEventIds() {
		return eventIds;
	}
	public void setEventIds(List<String> eventIds) {
		this.eventIds = eventIds;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

}
