package com.suunnytarwanni.BookMyShow.Service;


import com.suunnytarwanni.BookMyShow.Exception.InvalidArgumentException;
import com.suunnytarwanni.BookMyShow.Exception.SeatNotAvailableException;
import com.suunnytarwanni.BookMyShow.Model.*;
import com.suunnytarwanni.BookMyShow.Model.Constant.ShowSeatStatus;
import com.suunnytarwanni.BookMyShow.Model.Constant.TicketStatusFeature;
import com.suunnytarwanni.BookMyShow.Repository.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;

    public Ticket bookTicket(List<Long> seatIds , Long showId , Long userId) throws SeatNotAvailableException , InvalidArgumentException {
       List<Seat>seats = seatRepository.findAllByIdIn(seatIds);
        Optional<Show> show = showRepository.findById(showId);

        if(show.isEmpty()){
            throw new InvalidArgumentException("Show by " + showId +" is not Available");
        }
        List<ShowSeat> showSeats = checkAndLockSeat(seats , show);

        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()){
            throw new InvalidArgumentException("User with id " + userId + " doesn't Exist");
        }

        Ticket ticket = new Ticket();
        ticket.setAmount(0);
        ticket.setBookedBy(userOptional.get());
        ticket.setTimeOfBooking(new Date());
        ticket.setSeats(seats);
        ticket.setShow(show.get());
        ticket.setTicketStatusFeature(TicketStatusFeature.INPROGRESS);

        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE , timeout = 2)
    private List<ShowSeat> checkAndLockSeat(List<Seat> seats , Optional<Show> show) throws SeatNotAvailableException {

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInAndShow(seats, show.get());

        for(ShowSeat showSeat: showSeats){
            if(!(showSeat.getSeatStatus().equals(ShowSeatStatus.AVAILABLE)) || (showSeat.getSeatStatus().equals(ShowSeatStatus.LOCKED))){
                throw new SeatNotAvailableException("SELECTED SEAT IS NOT AVAILABLE");
            }
        }

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(ShowSeat showSeat : showSeats){
            showSeat.setLockedAt(new Date());
            showSeat.setSeatStatus(ShowSeatStatus.LOCKED);
             showSeatList.add(showSeatRepository.save(showSeat));
        }

        return showSeats;
    }
}
