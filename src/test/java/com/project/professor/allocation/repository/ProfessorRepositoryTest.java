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

import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class ProfessorRepositoryTest {
	
	 @Autowired
	    ProfessorRepository professorRepository;

	    @Test
	    public void findAll() {
	        // Act
	        List<Professor> professor = professorRepository.findAll();

	        // Print
	        System.out.println();
	    }

	    @Test
	    public void findById() {
	        // Arrange
	        

	        // Act
	        Optional<Professor> optional = professorRepository.findById(2L);

	        // Print
	        Professor prof = optional.orElse(null);
	        System.out.println(prof);
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
	    	Professor professor = new Professor();
			professor.setCpf("22222222222");
			professor.setDepartmentId(1L);
			professor.setName("Tiago Tiago");

	        // Act
			Professor prof = professorRepository.save(professor);

	        // Print
			System.out.println(prof);
	    }

	    @Test
	    public void save_update() throws ParseException {
	        // Arrange
	    	Professor professor = new Professor();
			professor.setDepartmentId(1L);
			professor.setCpf("22222222223");
			professor.setName("Gabriel Viana");

	        // Act
			Professor prof = professorRepository.save(professor);

	        // Print
			System.out.println(prof);
	    }

	    @Test
	    public void deleteById() {
	        // Arrange
	        

	        // Act
	    	professorRepository.deleteById(5L);
	    }

	    @Test
	    public void deleteAll() {
	        // Act
	        
	    }

}
