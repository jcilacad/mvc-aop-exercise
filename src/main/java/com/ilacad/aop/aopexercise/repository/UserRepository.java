package com.ilacad.aop.aopexercise.repository;

import com.ilacad.aop.aopexercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
