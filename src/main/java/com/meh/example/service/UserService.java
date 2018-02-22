package com.meh.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meh.example.model.UserModel;

@Service
public interface UserService {

	public List<UserModel> getAllUsers();
}
