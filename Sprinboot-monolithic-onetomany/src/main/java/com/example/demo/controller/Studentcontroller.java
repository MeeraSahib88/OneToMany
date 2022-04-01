package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.request.CommonDtoRequest;
import com.example.demo.services.StudentServices;

@RestController
@RequestMapping("api/student")
public class Studentcontroller {
	
	@Autowired
	StudentServices studentServices;
	
	@PostMapping("/save/profile")
	ResponseEntity<?> saveProfile(@RequestBody CommonDtoRequest commonDtoRequest){
		return studentServices.saveProfile(commonDtoRequest);
	}
	@GetMapping("/get/all")
	ResponseEntity<?> getall(){
		return studentServices.getall();
	}
	@PostMapping("/update/profile")
	ResponseEntity<?> updateProfile(@RequestBody CommonDtoRequest commonDtoRequest){
		return studentServices.updateProfile(commonDtoRequest);
	}
	@GetMapping("/get/by/studentId/{id}")
	ResponseEntity<?> getbyId(@PathVariable(name = "id") String id){
		return studentServices.getById(id);
		
	}
	@DeleteMapping("/delet/by/studentId/{id}")
	ResponseEntity<?> deleteById(@PathVariable(name = "id") String id){
		return studentServices.deleteById(id);
		
	}

}
