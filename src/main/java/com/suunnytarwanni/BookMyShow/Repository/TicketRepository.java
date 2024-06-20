package com.suunnytarwanni.BookMyShow.Repository;

import com.suunnytarwanni.BookMyShow.Model.Show;
import com.suunnytarwanni.BookMyShow.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    Ticket save(Ticket ticket);
}
