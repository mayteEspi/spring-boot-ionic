package com.meh.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meh.example.model.UserModel;
import com.meh.example.service.UserService;


@RestController
public class ExampleRestController {
	
	private static Log log = LogFactory.getLog(ExampleRestController.class);

	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserModel>> getUsers() {
		ResponseEntity<List<UserModel>> responseListEntity = null;
		try {
			responseListEntity = new ResponseEntity<List<UserModel>>(service.getAllUsers(), HttpStatus.OK);
		} catch (Exception exception) {
			log.error(exception);
			responseListEntity =new ResponseEntity<List<UserModel>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseListEntity;
	}
}
