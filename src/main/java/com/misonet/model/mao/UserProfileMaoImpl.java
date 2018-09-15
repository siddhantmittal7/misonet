package com.misonet.model.mao;

import org.bson.Document;
import org.springframework.stereotype.Repository;

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

	@Override
	public void insertNewUser() {
		

		MongoClientURI uri = new MongoClientURI( "mongodb+srv://mongodb:mongodb@cluster0-qlnsf.mongodb.net");
		
		MongoClient mongoClient = null;
		mongoClient = new MongoClient(uri);
		mongoClient.getReplicaSetStatus();
		
	 MongoDatabase m = mongoClient.getDatabase("swift");
	 
	 MongoCollection<Document> c = m.getCollection("users");
	 
	 
	
	 
	 org.bson.Document doc = new org.bson.Document();
	 
	
	 
	 doc.append("name", "Aswin");
	 
	 BasicDBObject b = new BasicDBObject(doc);
	 
	 FindIterable<Document> d = c.find(b);
	 
	 System.out.println(d.first().get("age"));
	 
	 mongoClient.close();
	 
	 
//		MongoDatabase database = mongoClient.getDatabase("test");

//		mongoOperations.save(userProfile);	
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
