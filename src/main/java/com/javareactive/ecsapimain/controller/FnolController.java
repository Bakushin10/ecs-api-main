package com.javareactive.ecsapimain.controller;

import com.javareactive.ecsapimain.entity.Fnol;
import com.javareactive.ecsapimain.entity.Person;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class FnolController {

    @GetMapping("/fnol")
    public Fnol getPerson(){
        System.out.println("----- fnol get request -----");
        Fnol fnol = new Fnol(
                1,
                "John",
                "9090",
                "product",
                "John Oliver",
                "circle",
                "johnoliver@lwt.com",
                "232",
                "",
                "Tokyo",
                "10/23/2022",
                "Hospotal2");
        return fnol;
    }
}
