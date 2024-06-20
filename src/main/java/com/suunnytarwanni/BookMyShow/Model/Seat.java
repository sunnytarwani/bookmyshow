package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.SeatStatus;
import com.suunnytarwanni.BookMyShow.Model.Constant.SeatTypeFeature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{

    private int row;
    private int col;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
}
