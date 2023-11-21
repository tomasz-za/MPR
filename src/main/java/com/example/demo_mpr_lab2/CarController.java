package com.example.demo_mpr_lab2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

@GetMapping ("Car/{name}")

    public Car getCarName(@PathVariable("name") String name) {
        return this.service.getRepositoryName(name);
}

@GetMapping("Car/show")
    public ArrayList<Car> ShowCars(){
        return service.displayCarRepository() ;
}


@PostMapping("Car/add")
    public void addCarToRepository(@RequestBody Car car){
        this.service.addCarToRepository(car);
}

@PutMapping("Car/update/{name}")
    public void updateCarInRepository(@PathVariable("name") String name,@RequestBody Car updatedCar){
        service.updateCarByName(name, updatedCar);
}

@DeleteMapping("Car/delete/{name}")
    public void deletaCarInRepository(@PathVariable("name") String name) {
        service.deleteFromCarRepository(name);
}

}

