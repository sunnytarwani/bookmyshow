package com.suunnytarwanni.BookMyShow.Model;


import com.suunnytarwanni.BookMyShow.Model.Constant.PaymentModeFeature;
import com.suunnytarwanni.BookMyShow.Model.Constant.PaymentStatusFeature;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private int amount;
    private Date time;
    private String referenceId;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentStatusFeature paymentStatusFeature;
    @Enumerated(EnumType.STRING)
    private PaymentModeFeature paymentModeFeature;
}
