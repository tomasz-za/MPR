package com.example.demo_mpr_lab2;

import exceptions.CarAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
    private MockMvc mockMvc;

    @Mock
    private CarService service;
    @InjectMocks
    private CarController controller;
    @BeforeEach
    public void setup(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new CarExceptionHandler(), controller).build();
    }
/**
    @Test
    public void gerByIdReturns200WhenCarIsPresent() throws Exception{
        Car testcar1 = new Car("car400", "white");
        when(service.findByName("car400")).thenReturn(Optional.of(testcar1));

        mockMvc.perform(MockMvcRequestBuilders.get("/Car/car400"))
                .andExpect(jsonPath("$.name").value("car400"))
                .andExpect(jsonPath("$.color").value("white"))
                .andExpect(status().isOk());

    }
    */

    @Test
    public void iTest() throws Exception{

    }

}
