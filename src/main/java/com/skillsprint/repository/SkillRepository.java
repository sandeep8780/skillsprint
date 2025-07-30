package com.skillsprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillsprint.entity.Skill;
import java.util.List;


public interface SkillRepository extends JpaRepository<Skill, Long> {
	List<Skill> findByClass(String status );
	
	
	

}
