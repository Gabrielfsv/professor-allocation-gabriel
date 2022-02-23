package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;

	public AllocationService(AllocationRepository allocationRepository) {
		super();
		this.allocationRepository = allocationRepository;
	}

	public List<Allocation> findAll() {
		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}

	public Allocation findById(Long id) {
		Optional<Allocation> optional = allocationRepository.findById(id);
		Allocation allocation = optional.orElse(null);
		return allocation;
	}

	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		Allocation allocationNew = allocationRepository.save(allocation);
		return allocationNew;
	}

	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {
			Allocation allocationNew = allocationRepository.save(allocation);
			return allocationNew;
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) 
		{
			allocationRepository.existsById(id);
		}

	}
	public void deleteAll()
	{
		allocationRepository.deleteAllInBatch();
	}
}
