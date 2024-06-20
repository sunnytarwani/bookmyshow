package com.suunnytarwanni.BookMyShow.Repository;

import com.suunnytarwanni.BookMyShow.Model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat , Integer> {
    Seat findSeatBySeatNumber(String seatNumber);
    List<Seat> findAllByIdIn(List<Long> seatIds);
}
