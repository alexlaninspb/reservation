package com.example.reservation.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class Car {
	@Pattern(regexp = "C\\d+", message = "Id pattern is C<digits>")
	private String id;
	private String make;
	private String model;

	public Car(String make, String model, String id) {
		this.make = make;
		this.model = model;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car{" +
				"id='" + id + '\'' +
				", make='" + make + '\'' +
				", model='" + model + '\'' +
				'}';
	}
}
