package com.javareactive.ecsapimain.repository;

import com.javareactive.ecsapimain.entity.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, String> {
}
