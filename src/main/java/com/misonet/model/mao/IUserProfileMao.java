package com.misonet.model.mao;

import com.misonet.model.UserProfile;

public interface IUserProfileMao {

	String insertNewUser(UserProfile userProfile);
	
	void getFeed(String userid);
}
