package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libary")
public class Libary {
	
	@Id
	@GenericGenerator( name = "uuid-gen", strategy = "uuid2" )
	@GeneratedValue(generator = "uuid-gen")
	private String id;
	
	private String name;

	private String block;
	
	 @OneToMany(targetEntity = Student.class,cascade = CascadeType.ALL)
	 private List<Student> student= new ArrayList<Student>();
	

}
