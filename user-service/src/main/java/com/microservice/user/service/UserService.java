package com.microservice.user.service;

import com.microservice.user.dto.Department;
import com.microservice.user.dto.ResponeUserDepartmentDto;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	public User saveUser (User user) {
		log.info("Inside saveUser of UserService.");
		return userRepository.save(user);
	}

	public ResponeUserDepartmentDto getUserWithDepartmentById (Long userId) {
		log.info("Inside getUserById of UserService.");
		User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("No User available for the id : " + userId));
		return ResponeUserDepartmentDto.builder()
				.user(user)
				.department(restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class))
				.build();
	}
}
