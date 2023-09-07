package com.ilacad.aop.aopexercise.repository;

import com.ilacad.aop.aopexercise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}