package com.example.demo.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Libary;
import com.example.demo.entity.Student;
import com.example.demo.repository.LibaryRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.request.CommonDtoRequest;
import com.example.demo.request.MessageReponse;
import com.example.demo.services.StudentServices;

@Service
public class StudentServicesImpl implements StudentServices {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LibaryRepository libaryRepository;
	
	@Autowired
	Environment environment;

	@Override
	public ResponseEntity<?> saveProfile(CommonDtoRequest commonDtoRequest) {
		
		Student student = Student.builder().name(commonDtoRequest.getStudentname()).dep(commonDtoRequest.getDep())
				.build();
		studentRepository.save(student);
		

		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student);
		Libary libary = Libary.builder().block(commonDtoRequest.getBlock()).name(commonDtoRequest.getName())
				.student(list)
				.build();
		libaryRepository.save(libary);
		return ResponseEntity
				.ok(new MessageReponse(HttpStatus.OK.value(), ("success"), student));
	}

	@Override
	public ResponseEntity<?> getall() {
		List<Student> students=studentRepository.findAll();
		return ResponseEntity
				.ok(new MessageReponse(HttpStatus.OK.value(), ("success"), students));
	}

	@Override
	public ResponseEntity<?> updateProfile(CommonDtoRequest commonDtoRequest) {
		Optional<Student>optional=studentRepository.findById(commonDtoRequest.getId());
		if (!optional.isPresent()) {
			return ResponseEntity
					.ok(new MessageReponse(HttpStatus.OK.value(), ("no record"), optional));
		}
		Student  student=optional.get();
		student.setDep(commonDtoRequest.getDep());
		student.setName(commonDtoRequest.getStudentname());
		studentRepository.save(student);
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student);
		Optional<Libary>optionals=libaryRepository.findById(commonDtoRequest.getLibaryId());
		if (!optionals.isPresent()) {
			return ResponseEntity
					.ok(new MessageReponse(HttpStatus.OK.value(), ("no record"), optionals));
		}
		Libary libary = optionals.get();
		libary.setBlock(commonDtoRequest.getBlock());
		libary.setName(commonDtoRequest.getName());
		libary.setStudent(list);
		libaryRepository.save(libary);
		return ResponseEntity
				.ok(new MessageReponse(HttpStatus.OK.value(),("success"), student));
	}

	@Override
	public ResponseEntity<?> getById(String id) {
		Optional<Student>optional=studentRepository.findById(id);
		if (!optional.isPresent()) {
			return ResponseEntity
					.ok(new MessageReponse(HttpStatus.OK.value(), ("no record"), optional));
		}
		Student  student=optional.get();
		return ResponseEntity
				.ok(new MessageReponse(HttpStatus.OK.value(),("success"), student));
	}

	@Override
	public ResponseEntity<?> deleteById(String id) {
		libaryRepository.deleteById(id);
		return ResponseEntity
				.ok(new MessageReponse(HttpStatus.OK.value(),("success.Delete"), null));
	}
	

}
