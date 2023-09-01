package com.example.demo.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class ResourceNotFoundException  extends RuntimeException{

	private String message;
	}


