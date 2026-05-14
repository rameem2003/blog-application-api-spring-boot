package com.rameem.blogapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rameem.blogapi.model.BlogModel;

public interface BlogRepository extends JpaRepository<BlogModel, Long> {
    // get blog by user id
    List<BlogModel> findByUserId(Long userId);
}
