package com.meh.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.meh.example.model.UserModel;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public List<UserModel> getAllUsers(){
		List<UserModel> users = new ArrayList<UserModel>();
		UserModel user1 = new UserModel("Mayte", "maytehermida@gmail.com", "33");
		UserModel user2 = new UserModel("Example", "example@gmail.com");
		users.add(user1);
		users.add(user2);
		return users;
	}
}
