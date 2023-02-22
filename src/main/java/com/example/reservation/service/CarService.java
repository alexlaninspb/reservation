package com.example.reservation.service;

import com.example.reservation.domain.Car;

import java.util.List;

public interface CarService {
    public Car add (Car car);

    public boolean update (Car car);

    public boolean remove (String id);

    public List<Car> selectAll ();

    public List<Car> selectFreeCars ();

}
