package com.javareactive.ecsapimain.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class healthcheckControllerTest {

    @InjectMocks
    HealthcheckController healthcheckController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("should return heathy status")
    void shouldReturnHealthyStatus(){
        String response = healthcheckController.healthcheck();
        String expected = "healthy";
        Assertions.assertEquals(expected, response);
    }
}