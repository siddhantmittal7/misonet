package com.misonet.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "interestCollection")
public class InterestClass {
	
	@Id
	String id;
	String interestName;
	List<EventClass> events;
	List<UserProfile> users;
	
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
	public List<EventClass> getEvents() {
		return events;
	}
	public void setEvents(List<EventClass> events) {
		this.events = events;
	}
	public List<UserProfile> getUsers() {
		return users;
	}
	public void setUsers(List<UserProfile> users) {
		this.users = users;
	}

	

}
