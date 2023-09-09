package com.ilacad.aop.aopexercise.service;

import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;
import com.ilacad.aop.aopexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserDto userDto, boolean isVip) {

        // Getting the data from UserDto
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String email = userDto.getEmail();


        // Create an instance of User and Save in Database
        User user = new User(firstName, lastName, email);
        user.setVip(isVip);
        userRepository.save(user);

    }
}
