package com.project.professor.allocation.repository;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	public void findAll() {
		// Act
		List<Department> department = departmentRepository.findAll();
		// Print
		System.out.println(department);
	}

	@Test
	public void findById() {
		// Arrange

		// Act
		Optional<Department> optional = departmentRepository.findById(3L);
		// Print
		Department department = optional.orElse(null);
		System.out.println(department);
	}

	@Test
	public void findByProfessorId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void findByCourseId() {
		// Arrange

		// Act

		// Print

	}

	@Test
	public void save_create() throws ParseException {
		// Arrange
		Department department = new Department();
		department.setName("Saúde");
		// Act
		Department depart = departmentRepository.save(department);
		// Print
		System.out.println(depart);
	}

	@Test
	public void save_update() throws ParseException {
		// Arrange
		Department department = new Department();
		department.setId(2L);
		department.setName("Uniqualiti");
		// Act
		Department depart = departmentRepository.save(department);
		// Print
		System.out.println(depart);
	}

	@Test
	public void deleteById() {
		// Arrange

		// Act
		departmentRepository.deleteById(2L);
	}

	@Test
	public void deleteAll() {
		// Act

	}

}
