package com.alpha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alpha.db.JEntity;
import com.alpha.repository.JEntityRepository;

@Service
public class JEntityService {

	@Autowired
	JEntityRepository<JEntity> jEntityRepository;
	
	@Transactional
	
	public List<JEntity> getAll(){
		return (List<JEntity>) jEntityRepository.findAll();
	}
	
	public List<JEntity> getEntity(long id){
		return (List<JEntity>) jEntityRepository.findById(id);
	}
	
	
}
