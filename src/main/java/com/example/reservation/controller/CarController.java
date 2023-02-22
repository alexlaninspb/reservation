package com.example.reservation.controller;

import com.example.reservation.domain.Car;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.reservation.service.CarService;

import java.util.List;
import java.util.Set;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public ResponseEntity<String> add (String make, String model, String id){
        Car car = new Car(make, model, id);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Car>> violations = validator.validate(car);
        if(violations.isEmpty()){
            carService.add(car);
            return new ResponseEntity<>("Car " + car.toString() + " is succesfully added", HttpStatus.OK);
        } else {
            String str = "";
            for (ConstraintViolation<Car> violation : violations) {
                str += violation.getMessage();
            }
            return new ResponseEntity<>("Errors: " + str, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/updateCar")
    public ResponseEntity<Boolean> update (String make, String model, String id) {
        Car car = new Car(make, model, id);
        if(carService.update(car)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/removeCar")
    public boolean remove (String id){
        return carService.remove(id);
    }

    @GetMapping("/selectCars")
    public ResponseEntity<List<Car>> selectAll (){
        return new ResponseEntity<>(carService.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/selectFreeCars")
    public ResponseEntity<List<Car>> selectFreeCars (){
        return new ResponseEntity<>(carService.selectFreeCars(), HttpStatus.OK);
    }

}
