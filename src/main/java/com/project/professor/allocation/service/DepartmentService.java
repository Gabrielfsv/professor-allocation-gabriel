package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	// CRUID Ler todos

	public List<Department> findAll(String name) {
		if (name == null) {
			return departmentRepository.findAll();
		} else {
			return departmentRepository.findByNameContainingIgnoreCase(name);
		}
	}

	// CRUID Ler pelo id
	public Department findById(Long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		Department departments = optional.orElse(null);
		return departments;
	}

	// CRUID Criar
	public Department save(Department department) {
		department.setId(null);
		return departmentRepository.save(department);
	}

	// CRUID Atualizar
	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {
			return department = departmentRepository.save(department);
		} else {
			return null;
		}
	}

	// CRUID Deletar pelo Id

	public void deleteById(Long id) {
		if (id != null && departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}

	}

	// CRUID Deletar tudo
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}

}
