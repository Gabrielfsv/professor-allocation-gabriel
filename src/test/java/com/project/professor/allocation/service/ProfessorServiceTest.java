package com.project.professor.allocation.service;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Professor;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {
	
	@Autowired
	ProfessorService professorService;
	
	@Test
	public void findAll() {
		// Act
		List<Professor> professor = professorService.findAll("professor");

		// Print
		professor.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Arrange
		Long id = 1L;

		// Act
		Professor professor = professorService.findById(id);

		// Print
		System.out.println(professor);
	}

	@Test
	public void save() {
		// Arrange
		Professor professor = new Professor();
		professor.setId(null);
		professor.setCpf("21212121212");
		professor.setName("Gabriel Viana");
		professor.setDepartmentId(1L);
		
		// Act
		professor = professorService.create(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Professor professor = new Professor();
		professor.setId(6L);
		professor.setCpf("21212121212");
		professor.setName("Gabriel Vianna");
		professor.setDepartmentId(1L);

		// Act
		professor = professorService.update(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Arrange
		professorService.deleteById(6L);

		// Act
		
	}

	@Test
	public void deleteAll() {
		// Act
		
	}
}
