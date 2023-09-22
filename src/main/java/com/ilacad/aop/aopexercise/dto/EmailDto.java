package com.ilacad.aop.aopexercise.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDto {

    @NotEmpty(message = "Email Must Not Be Empty")
    private String email;

}
