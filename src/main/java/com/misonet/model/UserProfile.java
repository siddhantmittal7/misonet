package com.misonet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "userProfiles")
public class UserProfile {

    @Id
    String id;
    String name;
    List<String> interests;
    List<EventClass> events;
    int preferedDis;
    

    public int getPreferedDis() {
		return preferedDis;
	}

	public void setPreferedDis(int preferedDis) {
		this.preferedDis = preferedDis;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<EventClass> getEvents() {
		return events;
	}

	public void setEvents(List<EventClass> events) {
		this.events = events;
	}

	public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
