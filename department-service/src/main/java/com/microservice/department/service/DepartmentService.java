package com.microservice.department.service;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment (Department department) {
		log.info("Inside saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findByDepartmentId (Long departmentId) {
		log.info("Inside findByDepartmentId of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId)
				.orElseThrow(() -> new NoSuchElementException("No department available for the id = " + departmentId));
	}
}
