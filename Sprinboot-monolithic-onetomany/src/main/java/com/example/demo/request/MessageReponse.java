package com.example.demo.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class MessageReponse {
	
	private int status;
	
	private String message;
	
	private Object object;

	public MessageReponse(int status, String message, Object object) {
		super();
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public MessageReponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

}
