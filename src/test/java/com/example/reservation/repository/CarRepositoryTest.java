package com.example.reservation.repository;

import com.example.reservation.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @BeforeEach
    void clear(){
        ArrayList<Car> cars = carRepository.selectAll();
        for (Car c: cars){
            carRepository.remove(c.getId());
        }
    }

    @Test
    void add() {
        HashSet<Car> test = new HashSet<>();
        Car car1 = new Car("Auto", "Toyota", "C12345");
        Car car2 = new Car("Auto", "Toyota", "C12342");
        test.add(car1);
        test.add(car2);
        carRepository.add(car1);
        carRepository.add(car2);
        HashSet<Car> result = new HashSet<>(carRepository.selectAll());
        assertEquals(result, test);
    }
    @Test
    void update() {
        HashSet<Car> expect = new HashSet<>();
        Car car1 = new Car("Auto", "Toyota", "C12345");
        Car car2 = new Car("Auto", "BMW", "C12345");
        expect.add(car2);
        carRepository.add(car1);
        carRepository.update("C12345", "Auto", "BMW");
        HashSet<Car> result = new HashSet<>(carRepository.selectAll());
        assertEquals(result, expect);
    }

    @Test
    void remove() {
        HashSet<Car> expect = new HashSet<>();
        Car car1 = new Car("Auto", "Toyota", "C12345");
        Car car2 = new Car("Auto", "Toyota", "C12342");
        expect.add(car2);
        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.remove(car1.getId());
        HashSet<Car> result = new HashSet<>(carRepository.selectAll());
        assertEquals(result, expect);
    }

    @Test
    void selectAll() {
        HashSet<Car> test = new HashSet<>();
        Car car1 = new Car("Auto", "Toyota", "C12345");
        Car car2 = new Car("Auto", "Toyota", "C12342");
        test.add(car1);
        test.add(car2);
        carRepository.add(car1);
        carRepository.add(car2);
        HashSet<Car> result = new HashSet<>(carRepository.selectAll());
        assertEquals(result, test);
    }

}