package com.example.reservation.repository;

import com.example.reservation.domain.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@Component
public class CarRepository {
	private final Map<String, Car> cars = new HashMap<>();
	public Car add (Car car) {
		cars.put(car.getId(), car);
		return car;
	}
	public boolean update (String id, String make, String model) {
		if(cars.containsKey(id)) {
			cars.get(id).setMake(make);
			cars.get(id).setModel(model);
			return true;
		} else {
			return false;
		}
	}
	public boolean remove (String id) {
		if(cars.containsKey(id)) {
			cars.remove(id);
			return true;
		} else {
			return false;
		}
	}
	public ArrayList<Car> selectAll () {
		return new ArrayList<>(cars.values());
	}
}
