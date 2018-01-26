package com.tongtu.repository.postgres;

import com.tongtu.bean.postgres.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

  Collection<Reservation> findByReservationName(String name);
}
