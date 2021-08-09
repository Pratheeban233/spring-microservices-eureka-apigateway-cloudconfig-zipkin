package com.microservice.department.repository;

import com.microservice.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByDepartmentId (Long departmentId);
}
