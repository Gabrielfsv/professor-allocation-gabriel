package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;
	private DepartmentService departmentService;

	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}

	// CRUID Ler todos

	public List<Professor> findAll(String name) {
		if (name == null) {
			return professorRepository.findAll();
		} else {
			return professorRepository.findByNameContainingIgnoreCase(name);
		}
	}

	// CRUID Ler pelo id
	public Professor findById(Long id) {
		Optional<Professor> optional = professorRepository.findById(id);
		Professor professors = optional.orElse(null);
		return professors;
	}

	// CRUID Criar
	public Professor create(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}

	// CRUID Atualizar
	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {
			return saveInternal(professor);
		} else {
			return null;
		}
	}

	private Professor saveInternal(Professor professor) {
		professor = professorRepository.save(professor);

		Department department = departmentService.findById(professor.getDepartmentId());
		professor.setDepart(department);

		return professor;
	}

	// CRUID Deletar pelo Id

	public void deleteById(Long id) {
		if (id != null && professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}

	}

	// CRUID Deletar tudo
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}

}
