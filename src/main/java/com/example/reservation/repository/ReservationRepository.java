package com.example.reservation.repository;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationRepository {

    public HashSet<Reservation> reservations = new HashSet<>();
    public void add(Reservation reservation){
        reservations.add(reservation);
    };

    public List<Reservation> selectUpcoming(){
        return reservations.stream().filter(r-> r.getStart().isAfter(LocalDateTime.now())).collect(Collectors.toList());
    };

    public List<Reservation> selectUpcoming(Car car){
        return reservations.stream()
                .filter(r-> r.getStart().isAfter(LocalDateTime.now()))
                .filter(r-> r.getCar().equals(car))
                .collect(Collectors.toList());
    };

    public List<Reservation> selectAll(){
        return new ArrayList<>(reservations);
    }

}
