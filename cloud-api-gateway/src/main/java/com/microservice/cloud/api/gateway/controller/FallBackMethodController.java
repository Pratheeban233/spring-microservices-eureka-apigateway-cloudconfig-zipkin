package com.microservice.cloud.api.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fallback")
public class FallBackMethodController {


	private Logger logger = LoggerFactory.getLogger(FallBackMethodController.class);

	@GetMapping("/userServiceFallBack")
	public ResponseEntity<Object> userServiceFallBack () {
		logger.info("Inside userServiceFallBack of FallBackMethodController.");
		return ResponseEntity.ok("This user service taking more than expected time. Please try again later.");
	}

	@GetMapping("/departmentServiceFallBack")
	public ResponseEntity<Object> departmentServiceFallBack () {
		logger.info("Inside departmentServiceFallBack of FallBackMethodController.");
		return ResponseEntity.ok("This department service taking more than expected time. Please try again later.");
	}
}
