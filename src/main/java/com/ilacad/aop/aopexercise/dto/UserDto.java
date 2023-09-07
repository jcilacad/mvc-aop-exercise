package com.ilacad.aop.aopexercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotEmpty(message = "First Name Must Not Be Empty")
    private String firstName;

    @NotEmpty(message = "Last Name Must Not Be Empty")
    private String lastName;

    @NotEmpty(message = "Email Must Not Be Empty")
    @Email
    private String email;
}
