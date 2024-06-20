package com.suunnytarwanni.BookMyShow.Repository;

import com.suunnytarwanni.BookMyShow.Model.Seat;
import com.suunnytarwanni.BookMyShow.Model.Show;
import com.suunnytarwanni.BookMyShow.Model.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findAllBySeatInAndShow(List<Seat> seats , Show show);

        ShowSeat save(ShowSeat showSeat);
}
