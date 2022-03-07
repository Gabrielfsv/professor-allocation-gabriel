package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	// CRUID Ler todos

	public List<Course> findAll(String name) {
		if (name == null) {
			return courseRepository.findAll();
		} else {
			return courseRepository.findByNameContainingIgnoreCase(name);
		}
	}

	// CRUID Ler pelo id
	public Course findById(Long id) {
		Optional<Course> optional = courseRepository.findById(id);
		Course courses = optional.orElse(null);
		return courses;
	}

	// CRUID Criar
	public Course save(Course course) {
		course.setId(null);
		return courseRepository.save(course);
	}

	// CRUID Atualizar
	public Course update(Course professor) {
		Long id = professor.getId();
		if (id != null && courseRepository.existsById(id)) {
			Course courseNew = courseRepository.save(professor);
			return courseNew;
		} else {
			return null;
		}
	}

	// CRUID Deletar pelo Id

	public void deleteById(Long id) {
		if (id != null && courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
		}

	}

	// CRUID Deletar tudo
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
}
