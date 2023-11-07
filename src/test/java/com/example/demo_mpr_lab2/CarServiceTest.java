package com.example.demo_mpr_lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    @Mock
    private CarRepository repository;
    private AutoCloseable openMocks;
    private CarService carService;

    @BeforeEach
    public void init(){
        openMocks = MockitoAnnotations.openMocks(this);
        carService = new CarService(repository);
    }

    @AfterEach
    public void tearDown() throws Exception{
        openMocks.close();
    }

    @Test
    public void findFinds(){
        String name = "918";
        Car car222 = new Car("", "yellow");
        Mockito.when(repository.findByName(name)).thenReturn(car222);

        Car result = carService.repository.findByName(name);
        assertEquals(car222, result);

    }

    @Test
    public void saveSaves(){
        Car car11 = new Car("11", "yellow");
        ArgumentCaptor<Car> captor = ArgumentCaptor.forClass(Car.class);
        Mockito.when(repository.save(captor.capture())).thenReturn(car11);

        carService.addCarToRepository(car11);
        Mockito.verify(repository, Mockito.times(1)).save(car11);
        Car carFromSaveCall = captor.getValue();
        assertEquals(car11, carFromSaveCall);


    }

}
