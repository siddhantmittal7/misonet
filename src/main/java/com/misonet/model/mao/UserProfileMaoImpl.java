package com.misonet.model.mao;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.misonet.model.UserProfile;
import com.misonet.utils.MongoConnection;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class UserProfileMaoImpl implements IUserProfileMao {
	
	
//    @Autowired
//    @Qualifier("MongoTemplate")
//    private MongoOperations mongoOperations;
	
	static MongoConnection mongoConnection = new MongoConnection();
	
	
	private Document getUserProfileDocument(UserProfile userProfile) {
		
		Document document = new Document();
		document.append("name", userProfile.getName());
		document.append("interests", userProfile.getInterests());
		
		return document;
		
	}

	@Override
	public String insertNewUser(UserProfile userProfile) {
		

		MongoClientURI uri = new MongoClientURI(mongoConnection.MongoUrl());
		MongoClient mongoClient = null;
		mongoClient = new MongoClient(uri);
		mongoClient.getReplicaSetStatus();
		
		MongoDatabase m = mongoClient.getDatabase("swift");
	 
		MongoCollection<Document> c = m.getCollection("users");
	 
	 
		Document doc = getUserProfileDocument(userProfile);
	
		c.insertOne(doc);
	 
		mongoClient.close();
		
		return doc.get("_id").toString();
	}
	
	

	@Override
	public void getFeed(String userid) {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("_id").is(userid));
//        List<UserProfile> userProfiles = mongoOperations.find(query, UserProfile.class);
////        if(userProfiles != null && userProfiles.isEmpty()) {
////        	List<EventClass.java> list
////        }else {
////        	return null;
////        }
//		
//	}
	}
	
	

}
