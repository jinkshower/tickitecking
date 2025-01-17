package com.laydowncoding.tickitecking.domain.seat.repository;

import com.laydowncoding.tickitecking.domain.seat.entity.SeatPrice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatPriceRepository extends JpaRepository<SeatPrice, Long> {

    List<SeatPrice> findAllByConcertId(Long concertId);
}
