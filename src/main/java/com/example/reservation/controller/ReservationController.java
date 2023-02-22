package com.example.reservation.controller;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.reservation.service.ReservationService;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/addReservation")
    @ResponseBody
    public void add(@RequestBody Reservation reservation) {
        reservationService.add(reservation);
    }

    @GetMapping("/selectUpcomingReservations")
    public List<Reservation> selectUpcoming() {
        return reservationService.selectUpcoming();
    }

    @GetMapping("/selectUpcomingReservationsForCar")
    public List<Reservation> selectUpcoming(@RequestParam Car car) {
        return reservationService.selectUpcoming(car);
    }
}
