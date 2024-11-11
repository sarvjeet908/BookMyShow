package com.example.bms.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpResponseDTO {
       private Long userId;
       private ResponseStatus responseStatus;

}
