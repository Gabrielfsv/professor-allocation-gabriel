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

	public List<Department> findAll() {
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}

	// CRUID Ler pelo id
	public Department findById(Long id) {
		Optional<Department> optional = departmentRepository.findById(id);
		Department departments = optional.orElse(null);
		return departments;
	}

	// CRUID Criar
	public Department create(Department department) {
		department.setId(null);
		return saveInternal(department);
	}

	// CRUID Atualizar
	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {
			Department departmentNew = departmentRepository.save(department);
			return departmentNew;
		} else {
			return null;
		}
	}

	private Department saveInternal(Department department) {
		Department departmentNew = departmentRepository.save(department);
		return departmentNew;
	}

	// CRUID Deletar pelo Id

	public void deleteById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.existsById(id);
		}

	}

	// CRUID Deletar tudo
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}

}
