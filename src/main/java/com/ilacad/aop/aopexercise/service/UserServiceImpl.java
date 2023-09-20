package com.ilacad.aop.aopexercise.service;

import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;
import com.ilacad.aop.aopexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    private String name;
    private String serviceCode;

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

    public String getName() {
        System.out.println(getClass() + " - getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " - setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " - getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " - setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
