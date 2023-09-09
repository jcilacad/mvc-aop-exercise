package com.ilacad.aop.aopexercise.service;

import com.ilacad.aop.aopexercise.dto.UserDto;

public interface UserService {

    void addUser(UserDto userDto, boolean isVip);
}
