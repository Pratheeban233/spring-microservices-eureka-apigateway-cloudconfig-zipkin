package com.microservice.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Department implements Serializable {

	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
