package com.example.reservation.service;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.reservation.repository.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResevationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public void add(Reservation reservation) {
		LocalDateTime now = LocalDateTime.now();
		if(reservation.getStart().isAfter(now.plusHours(24))) {
			throw new RuntimeException("Reservation before 24 hours");
		}
		LocalDateTime start = reservation.getStart();
		LocalDateTime finish = reservation.getStart().plusHours(reservation.getHours());
		List<Reservation> reservations = reservationRepository.selectAll();
		for (Reservation r: reservations){
			LocalDateTime otherStart = r.getStart();
			LocalDateTime otherFiniSh = r.getStart().plusHours(r.getHours());
			if(otherStart.isAfter(start) && otherStart.isBefore(finish) ||
			   otherFiniSh.isAfter(start) && otherFiniSh.isBefore(finish) ||
				otherStart.isBefore(start) && otherFiniSh.isAfter(finish)
			){
				throw new RuntimeException("Reservation overlaps with another one: start " + otherStart + ", finish " + otherFiniSh);
			}
		}
		reservationRepository.add(reservation);
	}

	@Override
	public List<Reservation> selectUpcoming() {
		return reservationRepository.selectUpcoming();
	}

	@Override
	public List<Reservation> selectUpcoming(Car car) {
		return reservationRepository.selectUpcoming(car);
	}

}
