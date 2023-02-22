package com.example.reservation.service;

import com.example.reservation.domain.Car;
import com.example.reservation.domain.Reservation;
import com.example.reservation.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ResevationServiceImplTest {

    @Autowired
    ReservationService reservationService;

    @MockBean
    ReservationRepository reservationRepository;

    @Test
    void add() {
        LocalDateTime testDate = LocalDateTime.now().plusHours(25);
        Car car = new Car("Auto", "Toyota", "C12345");
        Reservation reservation = new Reservation(car, testDate, 1);
        assertThrows(RuntimeException.class, () -> reservationService.add(reservation));
    }

    @Test
    void selectUpcoming() {
    }

    @Test
    void testSelectUpcoming() {
    }
}