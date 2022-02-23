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

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class CourseRepositoryTest {
	
	 @Autowired
	    CourseRepository courseRepository;

	    @Test
	    public void findAll() {
	        // Act
	        List<Course> course = courseRepository.findAll(); 

	        // Print
	        System.out.println(course);
	    }

	    @Test
	    public void findById() {
	        // Arrange
	        

	        // Act
	    	Optional<Course> optional = courseRepository.findById(2L);

	        // Print
			Course Cour = optional.orElse(null);
			System.out.println(Cour);
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
	        Course course =new Course();
	        course.setName("UniQualiti");
	        // Act
	        

	        // Print
	        
	    }

	    @Test
	    public void save_update() throws ParseException {
	        // Arrange
	        

	        // Act
	        

	        // Print
	        
	    }

	    @Test
	    public void deleteById() {
	        // Arrange
	        

	        // Act
	        
	    }

	    @Test
	    public void deleteAll() {
	        // Act
	        
	    }
	

}
