package com.tongtu.controller;

import com.tongtu.bean.postgres.Reservation;
import com.tongtu.repository.postgres.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;

@RestController
public class ReservationRestController {

    @Autowired
    private  ReservationRepository reservationRepository;

//    public ReservationRestController(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }

    @GetMapping(value = "/reservations")
    Collection<Reservation> reservations() {
//        return Collections.emptyList();
        return this.reservationRepository.findAll();
    }
}
