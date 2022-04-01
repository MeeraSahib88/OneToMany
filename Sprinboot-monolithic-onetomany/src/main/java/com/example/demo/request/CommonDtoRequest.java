package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonDtoRequest {

	private String id;
	
	private String libaryId;
	private String Studentname;

	private String dep;
	private String name;

	private String block;

}
