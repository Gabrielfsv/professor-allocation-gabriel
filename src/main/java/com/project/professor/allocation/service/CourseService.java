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

	public List<Course> findAll() {
		List<Course> courses = courseRepository.findAll();
		return courses;
	}

	// CRUID Ler pelo id
	public Course findById(Long id) {
		Optional<Course> optional = courseRepository.findById(id);
		Course courses = optional.orElse(null);
		return courses;
	}

	// CRUID Criar
	public Course create(Course course) {
		course.setId(null);
		return saveInternal(course);
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

	private Course saveInternal(Course professor) {
		Course professorNew = courseRepository.save(professor);
		return professorNew;
	}

	// CRUID Deletar pelo Id

	public void deleteById(Long id) {
		if (courseRepository.existsById(id)) {
			courseRepository.existsById(id);
		}

	}

	// CRUID Deletar tudo
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
}
