package com.springlearning.journalApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userName;

    private String password;

    private boolean sentimentAnalysis;

    private String email;

}
