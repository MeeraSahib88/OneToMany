package com.example.demo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.request.CommonDtoRequest;

@Service
public interface StudentServices {

	ResponseEntity<?> saveProfile(CommonDtoRequest commonDtoRequest);

	ResponseEntity<?> getall();

	ResponseEntity<?> updateProfile(CommonDtoRequest commonDtoRequest);

	ResponseEntity<?> getById(String id);

	ResponseEntity<?> deleteById(String id);

}
