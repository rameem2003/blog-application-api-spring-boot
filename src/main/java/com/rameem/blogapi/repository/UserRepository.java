package com.rameem.blogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rameem.blogapi.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);

    // select * from user_model where email = email
}
