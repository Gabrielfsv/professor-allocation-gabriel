package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	private ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}
	
	//CRUID Ler todos
	
		public List<Professor> findAll() {
			List<Professor> professors = professorRepository.findAll();
			return professors;
		}

		//CRUID Ler pelo id
		public Professor findById(Long id) {
			Optional<Professor> optional = professorRepository.findById(id);
			Professor professors = optional.orElse(null);
			return professors;
		}

		//CRUID Criar	
		public Professor create(Professor professor) {
			professor.setId(null);
			return saveInternal(professor);
		}

		//CRUID Atualizar	
		public Professor update(Professor professor) {
			Long id = professor.getId();
			if (id != null && professorRepository.existsById(id)) {
				Professor professorNew = professorRepository.save(professor);
				return professorNew;
			} else {
				return null;
			}
		}
		
		private Professor saveInternal(Professor professor) {
			Professor professorNew = professorRepository.save(professor);
					return professorNew;
		}
		
		//CRUID Deletar pelo Id
		
		public void deleteById(Long id) {
			if (professorRepository.existsById(id)) {
				professorRepository.existsById(id);
			}

		}

		//CRUID Deletar tudo
		public void deleteAll() {
			professorRepository.deleteAllInBatch();
		}

}
