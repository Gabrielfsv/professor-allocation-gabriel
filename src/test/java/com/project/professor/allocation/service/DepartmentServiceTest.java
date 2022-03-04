package com.project.professor.allocation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentServiceTest {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");
	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {
		// Act
		List<Department> department = departmentService.findAll();

		// Print
		department.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Arrange
		Long id = 1L;

		// Act
		Department department = departmentService.findById(id);

		// Print
		System.out.println(department);
	}

	@Test
	public void save() {
		// Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("Universidade Qualiti");
		// Act
		department = departmentService.create(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Department department = new Department();
		
		department.setId(3L);
		department.setName("Exatas");
		

		// Act
		department = departmentService.update(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void deleteById() {
		// Arrange
		Long id = 3L;

		// Act
		departmentService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		// Act
		
	}

}
