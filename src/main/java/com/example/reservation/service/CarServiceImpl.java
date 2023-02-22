package com.example.reservation.service;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import com.example.reservation.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarRepository carRepository;
	@Autowired
	ReservationService reservationService;

	public Car add (Car car) {
		carRepository.add(car);
		return car;
	}

	public boolean update (Car car) {
		return carRepository.update(car.getId(), car.getMake(), car.getModel());
	}

	public boolean remove (String id) {
		return carRepository.remove(id);
	}

	public ArrayList<Car> selectAll () {
		return carRepository.selectAll();
	}

	@Override
	public List<Car> selectFreeCars() {
		return reservationService.selectUpcoming().stream().map(Reservation::getCar).collect(Collectors.toList());
	}

}
