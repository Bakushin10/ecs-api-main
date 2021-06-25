package com.javareactive.ecsapimain.controller;

import com.javareactive.ecsapimain.dto.Response;
import com.javareactive.ecsapimain.entity.Person;
import com.javareactive.ecsapimain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person")
    public Flux<Person> getPerson(){
        System.out.println("getPerson controller");
        Flux<Person> persons = personService.getPerson();
        return persons;
    }

    @PostMapping("/person")
    public Mono<Response> postPerson(){
        Response response = new Response();
        try {
            Person person = this.createPersonObject();
            return personService.savePerson(person).map(p -> {
                response.setData(p);
                response.setHttpcode(HttpStatus.OK);
                response.setMessage("data succesfully saved");
                return  response;
            });
        }catch (Exception e){
            response.setMessage(e.getMessage());
            response.setHttpcode(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        Mono failedResponse = Mono.just(response);
        return  failedResponse;
    }

    private Person createPersonObject(){
        Person person = new Person();

        // this gives null result
        personService.getPerson().count().subscribe(p->{ person.setId((int) (p + 1)); });
        person.setEmail("shin_nagai@gmail.com");
        person.setFirst_name("John");
        person.setLast_name("Nagai");
        person.setGender("Male");
        person.setIp_address("96.129.131.51");
        return person;
    }
}
