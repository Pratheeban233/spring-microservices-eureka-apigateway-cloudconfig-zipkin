package com.microservice.department.controller;

import com.microservice.department.entity.Department;
import com.microservice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public ResponseEntity<Department> saveDepartment (@RequestBody Department department) {
		log.info("Inside saveDepartment of DepartmentController");
		return ResponseEntity.ok(departmentService.saveDepartment(department));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findByDepartmentId (@PathVariable("id") Long departmentId) {
		log.info("Inside findByDepartmentId of DepartmentController");
		return ResponseEntity.ok(departmentService.findByDepartmentId(departmentId));
	}
}
