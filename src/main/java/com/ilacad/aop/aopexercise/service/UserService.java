package com.ilacad.aop.aopexercise.service;

import com.ilacad.aop.aopexercise.dto.EmailDto;
import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;

import java.util.List;

public interface UserService {

    void addUser(UserDto userDto, boolean isVip);

    String getName();

    String getServiceCode();

    void setName(String name);

    void setServiceCode(String name);

    List<User> findAllUsers();

    User findUserByEmail(EmailDto emailDto);
}
