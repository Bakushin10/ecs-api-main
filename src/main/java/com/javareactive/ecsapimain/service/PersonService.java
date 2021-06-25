package com.javareactive.ecsapimain.service;

import com.javareactive.ecsapimain.entity.Person;
import com.javareactive.ecsapimain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Flux<Person> getPerson(){
        System.out.println("getPerson service");
        return personRepository.findAll();
    }

    public Mono<Person> savePerson(Person person){
        return  personRepository.save(person);
    }
}
