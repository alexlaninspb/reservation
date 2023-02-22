package com.example.reservation.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


public class Reservation {

	private Long id;

	private Car car;

	@NotNull
	private LocalDateTime start;
	@Min(0)
	@Max(2)
	private int hours;
	public Reservation(Car car, LocalDateTime start, int hours) {
		this.setCar(car);
		this.setStart(start);
		this.setHours(hours);
	}

	public Reservation() {

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", car=" + car +
				", start=" + start +
				", hours=" + hours +
				'}';
	}
}
