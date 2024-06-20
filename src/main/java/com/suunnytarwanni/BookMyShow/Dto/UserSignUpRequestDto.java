package com.suunnytarwanni.BookMyShow.Dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequestDto {

    private String email;
    private String password;
}
