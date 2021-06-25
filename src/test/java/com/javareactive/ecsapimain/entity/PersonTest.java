package com.javareactive.ecsapimain.entity;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @BeforeEach
    void setUp(){

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    @DisplayName("should create Person Entity")
    void shouldCreatePersonEntityObject(){
        Person person = new Person(
                1,
                "John",
                "Oliver",
                "johnoliver@lastweektonight.com",
                "M",
                "111.111.11"
        );

        Assertions.assertAll(
                () -> assertEquals(person.getId(), 1),
                () -> assertEquals(person.getFirst_name(), "John"),
                () -> assertEquals(person.getLast_name(), "Oliver"),
                () -> assertEquals(person.getEmail(), "johnoliver@lastweektonight.com"),
                () -> assertEquals(person.getGender(), "M"),
                () -> assertEquals(person.getIp_address(), "111.111.11")
        );
    }

}