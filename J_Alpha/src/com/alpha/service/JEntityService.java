package com.alpha.service;

import java.util.List;
import java.util.Optional;

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
	
	@Transactional
	public JEntity getEntity(int id){
		Integer ids=id;
		return (((Optional<JEntity>) jEntityRepository.findById(ids)).isPresent()==true)?
				(((Optional<JEntity>) jEntityRepository.findById(ids)).get()):null;
	}
	
	public JEntity saveEntity(JEntity entity){
		jEntityRepository.save(entity);
		return entity;
	}
	
	public JEntity deleteEntity(JEntity entity){
		jEntityRepository.delete(entity);
		return entity;
	}
}
