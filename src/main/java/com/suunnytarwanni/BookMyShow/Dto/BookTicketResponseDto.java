package com.suunnytarwanni.BookMyShow.Dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDto {

    private int amount;
    private List<String> seatNumber;
    private String auditorumName;
    private String status;
    private String message;
}
