package com.skillsprint.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skillsprint.dto.SkillRequest;
import com.skillsprint.entity.Skill;
import com.skillsprint.service.SkillService;

@RestController
@RequestMapping("/api/skills")

public class SkillController {
	
	 @Autowired
	    private SkillService service;
	 
	 
	 @Value("${file.upload-dir}")
	    private String uploadDir;
	 
	 @PostMapping
	    public ResponseEntity<Skill> createSkill(@RequestPart("data") SkillRequest request,
	                                             @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
	        Skill skill = new Skill();
	        skill.setSkillName(request.getskillName());
	        skill.setStatus(request.getstatus());
	        skill.setHoursSpent(request.getHoursSpent());

	        if (file != null && !file.isEmpty()) {
	            String path = uploadDir + UUID.randomUUID() + "-" + file.getOriginalFilename();
	            file.transferTo(new File(path));
	            skill.setFilePath(path);
	        }
	        return ResponseEntity.ok(service.save(skill));
	 }
	 @GetMapping
	    public ResponseEntity<List<Skill>> getAll() {
	        return ResponseEntity.ok(service.getAll());
	    }

	 @PutMapping("/{id}")
	    public ResponseEntity<Skill> update(@PathVariable Long id, @RequestBody SkillRequest request) {
	        return ResponseEntity.ok(service.update(id, request));
	    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id) {
	        service.delete(id);
	        return ResponseEntity.noContent().build();

}
