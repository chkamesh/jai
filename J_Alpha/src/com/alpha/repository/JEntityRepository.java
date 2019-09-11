package com.alpha.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.alpha.db.JEntity;

public interface JEntityRepository<P> extends CrudRepository<JEntity, Integer> {
	public List<JEntity> findById(long id);
}
 