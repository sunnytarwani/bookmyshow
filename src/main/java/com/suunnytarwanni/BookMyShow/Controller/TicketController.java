package com.suunnytarwanni.BookMyShow.Controller;


import com.suunnytarwanni.BookMyShow.Dto.BookTicketRequestDto;
import com.suunnytarwanni.BookMyShow.Dto.BookTicketResponseDto;
import com.suunnytarwanni.BookMyShow.Exception.InvalidArgumentException;
import com.suunnytarwanni.BookMyShow.Exception.SeatNotAvailableException;
import com.suunnytarwanni.BookMyShow.Model.Seat;
import com.suunnytarwanni.BookMyShow.Model.Ticket;
import com.suunnytarwanni.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookmyshow")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/bookticket")
    public ResponseEntity<BookTicketResponseDto> bookTcket(@RequestBody BookTicketRequestDto bookTicketRequestDto) throws SeatNotAvailableException, InvalidArgumentException {
        Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds() , bookTicketRequestDto.getUserId(),  bookTicketRequestDto.getShowId());

        BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
        bookTicketResponseDto.setAmount(ticket.getAmount());
        bookTicketResponseDto.setStatus(String.valueOf(ticket.getTicketStatusFeature()));
        bookTicketResponseDto.setMessage("Your Tickets are Confirmed");
        bookTicketResponseDto.setAuditorumName("AUDI 1");

        List<String> seatNames = new ArrayList<>();
        for(Seat seat : ticket.getSeats()){
            seatNames.add(String.valueOf(seat));
        }

        bookTicketResponseDto.setSeatNumber(seatNames);
        return new ResponseEntity<>(bookTicketResponseDto , HttpStatus.CREATED);
    }
}
