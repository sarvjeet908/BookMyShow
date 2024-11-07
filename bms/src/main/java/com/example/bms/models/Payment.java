package com.example.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String refNo;
    private PaymentStatus status;
    private int amount;
    private PaymentGatewayProvide paymentGatewayProvide;
    private PaymentMOde paymentMode;

}
