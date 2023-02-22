package com.example.reservation.controller;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import com.example.reservation.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CarControllerTest {

    @MockBean
    CarService carService;

    @Autowired
    CarController carController;

    @Test
    void add() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carService.add(car)).thenReturn(car);
        ResponseEntity<String> entity = carController.add("Auto", "Toyota", "C12345");
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(entity.getBody(), "Car " + car + " is succesfully added");
    }

    @Test
    void update() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carService.update(car)).thenReturn(true);
        ResponseEntity<Boolean> entity = carController.update("Auto", "Toyota", "C12345");
        assertEquals(entity.getStatusCode(), HttpStatus.OK);
        assertEquals(entity.getBody(), true);
    }

    @Test
    void remove() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carService.remove(car.getId())).thenReturn(true);
        assertTrue(carService.remove(car.getId()));
        Mockito.when(carService.remove(car.getId())).thenReturn(false);
        assertFalse(carService.remove(car.getId()));
    }

    @Test
    void selectAll() {
        ArrayList<Car> cars = new ArrayList<>();
        Mockito.when(carService.selectAll()).thenReturn(cars);
        List<Car> cars1 = carService.selectAll();
        assertEquals(cars1, cars);
    }

    @Test
    void selectFreeCars() {
        ArrayList<Car> cars = new ArrayList<>();
        Mockito.when(carService.selectFreeCars()).thenReturn(cars);
        List<Car> cars1 = carService.selectFreeCars();
        assertEquals(cars1, new ArrayList<Car>());
    }
}