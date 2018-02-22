package com.meh.example.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
public class SpringBootApiForIonicUtil {

	public static <T> T jsonToObject(String json, Class<T> t) {
		T resp = null;
		try {
			Gson g = new Gson(); 
			resp = g.fromJson(json, t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp;
	}
	
	public static <T> List<T> listJsonToObject(String response) {
		ObjectMapper mapper = new ObjectMapper();
		List<T> objeto = new ArrayList<T>();
		try {
			TypeReference<List<T>> typeReference = new TypeReference<List<T>>(){};
			objeto = mapper.readValue(response, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objeto;
	}
}
