package com.misonet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="eventCollection")
public class EventClass {

	@Id
	String id;
	String eventName;
	
	
}
