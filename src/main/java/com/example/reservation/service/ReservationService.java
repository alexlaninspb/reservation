package com.example.reservation.service;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;

import java.util.List;

public interface ReservationService {

     public void add(Reservation reservation);
     public List<Reservation> selectUpcoming();
     public List<Reservation> selectUpcoming(Car car);
}
