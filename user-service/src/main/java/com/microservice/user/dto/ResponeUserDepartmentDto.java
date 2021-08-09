package com.microservice.user.dto;

import com.microservice.user.entity.User;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ResponeUserDepartmentDto implements Serializable {

	private User user;
	private Department department;
}
