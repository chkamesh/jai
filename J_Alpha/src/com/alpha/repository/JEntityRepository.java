package com.alpha.repository;

import org.springframework.data.repository.CrudRepository;

import com.alpha.db.JEntity;

public interface JEntityRepository<P> extends CrudRepository<JEntity, Integer> {
}
 