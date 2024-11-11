package com.example.bms.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "show_name")
@Getter
@Setter
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    @OneToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
}
