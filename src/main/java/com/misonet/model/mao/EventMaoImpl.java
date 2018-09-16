package com.misonet.model.mao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.misonet.model.EventClass;
import com.misonet.utils.MongoConnection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EventMaoImpl implements IEventMao{

	
	static MongoConnection mongoConnection = new MongoConnection();
	
	private Document createEventDoc(EventClass event) {
		Document document = new Document();
		document.append("eventName", event.getEventName());
		document.append("desc", event.getDesc());
		document.append("location", event.getLocation());
		document.append("interest", event.getInterest());
		
		return document;
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	@Override
	public EventClass creatEvent(EventClass event, String userid) {
		
		MongoClientURI uri = new MongoClientURI(mongoConnection.MongoUrl());
		MongoClient mongoClient = null;
		mongoClient = new MongoClient(uri);
		mongoClient.getReplicaSetStatus();
		
		MongoDatabase m = mongoClient.getDatabase("swift");
	 
		MongoCollection<Document> c_events = m.getCollection("events");
		MongoCollection<Document> c_users = m.getCollection("users");
		MongoCollection<Document> c_interests = m.getCollection("interests");
		
		Document doc = createEventDoc(event);
		
		c_events.insertOne(doc);
		
		event.setId(doc.getString("_id"));
		
		FindIterable<Document> userProfile = c_users.find(new Document("_id",userid));
		
		if(userProfile.first() != null) {
			
			Document userDoc = userProfile.first();
			List<EventClass> listOfEvnets = (List<EventClass>) userProfile.first().get("events");
			
			if(listOfEvnets != null) {
				
				listOfEvnets.add(event);
				
				userDoc.replace("events", listOfEvnets);
				
				c_users.findOneAndReplace(new Document("_id",userid), userDoc);
			}else {
				
				List<EventClass> newListOfEvents = new ArrayList<EventClass>();
				newListOfEvents.add(event);
				userDoc.replace("events", newListOfEvents);
				
				c_users.findOneAndReplace(new Document("_id",userid), userDoc);
			}
		}
		
		FindIterable<Document> interestPageList = c_interests.find(new Document("interest",event.getInterest()));
		
		if(interestPageList.first() != null) {
			
			Document interetPage = interestPageList.first();
			List<EventClass> listOfEvnets = (List<EventClass>) interetPage.get("events");
			
			if(listOfEvnets != null) {
				
				listOfEvnets.add(event);
				
				interetPage.replace("events", listOfEvnets);
				
				c_interests.findOneAndReplace(new Document("interest",event.getInterest()), interetPage);
			}else {
				
				List<EventClass> newListOfEvents = new ArrayList<EventClass>();
				newListOfEvents.add(event);
				interetPage.replace("events", newListOfEvents);
				
				c_interests.findOneAndReplace(new Document("interest",event.getInterest()), interetPage);
			}
		}
		
		return event;
	}

}
