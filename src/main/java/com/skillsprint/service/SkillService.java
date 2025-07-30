package com.skillsprint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillsprint.dto.SkillRequest;
import com.skillsprint.entity.Skill;
import com.skillsprint.repository.SkillRepository;

public class SkillService {
	@Autowired
	private SkillRepository repo; 
	
	public Skill save(Skill skill) {
		return repo.save(skill);
	}
	
	public List<Skill> getAll(){
		return repo.findAll();
	}
	public Skill update (Long id , SkillRequest request) {
		SKill skill = repo.findById(id).orElseThrow();
		
		skill.setSkillName(request.getskillName());
		skill.setStatus(request.getstatus());
		skill.setHoursSpent(request.getHoursSpent());
		
		return repo.save(skill);
		
	}
	public void delete(Long id) {
        repo.deleteById(id);
	
}
}