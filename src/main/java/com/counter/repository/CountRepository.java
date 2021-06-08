package com.counter.repository;

import com.counter.model.CountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountRepository extends CrudRepository<CountEntity, Long> {
}
