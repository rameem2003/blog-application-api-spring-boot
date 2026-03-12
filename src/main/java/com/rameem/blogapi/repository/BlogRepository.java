package com.rameem.blogapi.repository;

import com.rameem.blogapi.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogModel, Long> {

}
