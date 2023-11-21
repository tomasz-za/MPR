package com.example.demo_mpr_lab2;

import exceptions.CarAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
        this.repository.save(new Car("718", "blue"));
        this.repository.save(new Car("911", "white"));
        this.repository.save(new Car("s5", "black"));
    }

    public Car getRepositoryName(String name) {
        return this.repository.findByName(name);
    }

    public void addCarToRepository(Car car) {
        if(repository.findByName(car.getName()) != null) {
            throw new CarAlreadyExistsException();
        } else {
            repository.save(car);
        }
    }

    public void updateCarByName(String name, Car updatedCar) {


        Car existingCar = repository.findByName(name);

        if (existingCar != null) {   
            existingCar.setName(updatedCar.getName());
            existingCar.setColor(updatedCar.getColor());

            repository.save(existingCar);
        }
    }

    public void deleteFromCarRepository(String name) {
        Car existingCar = repository.findByName(name);

        if (existingCar != null) {
            repository.delete(existingCar);
        }
    }

    public ArrayList<Car> displayCarRepository(){
        return (ArrayList<Car>) repository.findAll();

    }

}




    public Car findByName(String name){

        return this.repository.findByName(name);
    }
