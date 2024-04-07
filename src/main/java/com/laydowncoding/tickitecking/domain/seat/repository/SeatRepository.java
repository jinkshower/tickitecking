package com.laydowncoding.tickitecking.domain.seat.repository;

import com.laydowncoding.tickitecking.domain.seat.entity.Seat;
import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface SeatRepository extends JpaRepository<Seat, Long>, SeatRepositoryQuery {

  List<Seat> findAllByConcertId(Long concertId);

//  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Seat findByConcertIdAndHorizontalAndVertical(Long concertId, String horizontal, String vertical);

  List<Seat> findAllByAuditoriumIdAndHorizontalAndVertical(Long auditoriumId, String horizontal, String vertical);
}
