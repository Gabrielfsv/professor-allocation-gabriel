package com.project.professor.allocation.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.service.AllocationService;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {

	private final AllocationService allocationService;

	public AllocationController(AllocationService allocationService) {
		super();
		this.allocationService = allocationService;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	// public List<Allocation> findAll()
	// GET http://localrost:8080/departments
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<>(allocations, HttpStatus.OK);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "/{allocation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Allocation> findById(@PathVariable("allocation_id") Long id) {
		Allocation allocation = allocationService.findById(id);

		if (allocation != null) {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		} else {
			// return null;
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ResponseStatus(HttpStatus.CREATED)
	// READ, CREATE, UPDATE, DELETE
	// GET , POST , PUT , DELETE
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {
		try {
			Allocation newAllocation = allocationService.create(allocation);
			return new ResponseEntity<Allocation>(newAllocation, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Allocation>(HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(
			path = "/{allocation_id}", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Allocation> update(
			@PathVariable(name = "allocation_id") Long id,
			@RequestBody Allocation allocation) 
		{
		allocation.setId(id);
		try {
			Allocation newAllocation = allocationService.update(allocation);
			if (newAllocation != null) {
				return new ResponseEntity<Allocation>(newAllocation, HttpStatus.OK);
			} else {
				return new ResponseEntity<Allocation>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Allocation>(HttpStatus.BAD_REQUEST);
		}
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{allocation_id}")
	public ResponseEntity<Void> deleteById(@PathVariable(name = "allocation_id") Long id)
	{
		allocationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping
	public ResponseEntity<Void> deleteAll()
	{
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
