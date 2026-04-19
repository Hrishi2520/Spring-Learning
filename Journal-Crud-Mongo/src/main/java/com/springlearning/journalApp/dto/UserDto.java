package com.springlearning.journalApp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    private boolean sentimentAnalysis;

    private String email;

}
