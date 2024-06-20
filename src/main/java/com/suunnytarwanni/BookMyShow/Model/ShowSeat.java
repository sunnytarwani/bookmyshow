package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{

    private Date lockedAt;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus seatStatus;
}
