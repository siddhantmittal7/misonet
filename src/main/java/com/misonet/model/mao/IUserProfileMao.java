package com.misonet.model.mao;

import com.misonet.model.UserProfile;

public interface IUserProfileMao {

	void insertNewUser();
	
	void getFeed(String userid);
}
