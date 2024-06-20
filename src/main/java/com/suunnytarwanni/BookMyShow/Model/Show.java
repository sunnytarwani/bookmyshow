package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @Enumerated(EnumType.ORDINAL)
    private Language language;

}
