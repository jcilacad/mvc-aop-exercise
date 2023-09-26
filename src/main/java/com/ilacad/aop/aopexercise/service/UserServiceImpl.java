package com.ilacad.aop.aopexercise.service;

import com.ilacad.aop.aopexercise.dto.EmailDto;
import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;
import com.ilacad.aop.aopexercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

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

    @Override
    public User findUserByEmail(EmailDto emailDto) {

        // Get the email from the form
        String email = emailDto.getEmail();

        // Check if the user is in the record
        Optional<User> result = userRepository.findByEmailIgnoreCaseContaining(email);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find email - "  + email);
        }

        // Add a delay of 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
        

        // Return user
        return user;

    }
}
