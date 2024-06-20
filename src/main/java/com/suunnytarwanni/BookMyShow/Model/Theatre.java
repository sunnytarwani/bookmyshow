package com.suunnytarwanni.BookMyShow.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.event.spi.PreInsertEvent;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    private String name;
    private String address;
    @OneToMany
    private List<Auditorium> auditoriums;

    @ManyToOne
    private City city;
}
