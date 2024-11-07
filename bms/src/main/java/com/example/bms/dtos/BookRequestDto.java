package com.example.bms.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookRequestDto {
    private Long userId;
    private List<Long> showseatIds;
    private Long showId;
}
