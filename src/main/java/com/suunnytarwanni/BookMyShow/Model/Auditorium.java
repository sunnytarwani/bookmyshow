package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.AuditroiumFeature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium extends BaseModel {

    private String name;
    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<AuditroiumFeature> features;
}
