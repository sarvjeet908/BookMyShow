package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String refNo;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentGatewayProvide paymentGatewayProvide;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMOde paymentMode;

}
