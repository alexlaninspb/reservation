package com.example.reservation.service;

import com.example.reservation.controller.CarController;
import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import com.example.reservation.repository.CarRepository;
import com.example.reservation.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CarServiceImplTest {

    @MockBean
    CarRepository carRepository;

    @MockBean
    ReservationService reservationService;

    @Autowired
    CarService carService;

    @Test
    void add() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carRepository.add(car)).thenReturn(car);
        Car add = carRepository.add(car);
        assertEquals(add, car);
    }
    @Test
    void update() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carRepository.update(car.getId(), car.getMake(), car.getModel())).thenReturn(true);
        assertTrue(carRepository.update(car.getId(), car.getMake(), car.getModel()));
        Mockito.when(carRepository.update(car.getId(), car.getMake(), car.getModel())).thenReturn(false);
        assertFalse(carRepository.update(car.getId(), car.getMake(), car.getModel()));
    }
    @Test
    void remove() {
        Car car = new Car("Auto", "Toyota", "C12345");
        Mockito.when(carRepository.remove(car.getId())).thenReturn(true);
        assertTrue(carRepository.remove(car.getId()));
        Mockito.when(carRepository.remove(car.getId())).thenReturn(false);
        assertFalse(carRepository.remove(car.getId()));
    }
    @Test
    void selectAll() {
        ArrayList<Car> cars = new ArrayList<>();
        Mockito.when(carRepository.selectAll()).thenReturn(cars);
        List<Car> cars1 = carService.selectAll();
        assertEquals(cars1, cars);
    }
    @Test
    void selectFreeCars() {
        ArrayList<Reservation> reservations = new ArrayList<>();
        Mockito.when(reservationService.selectUpcoming()).thenReturn(reservations);
        List<Car> cars1 = carService.selectFreeCars();
        assertEquals(cars1, new ArrayList<Car>());
    }

}