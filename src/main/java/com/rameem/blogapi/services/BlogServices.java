package com.rameem.blogapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameem.blogapi.model.BlogModel;
import com.rameem.blogapi.repository.BlogRepository;

@Service
public class BlogServices {
    @Autowired
    private BlogRepository blogRepository;

    public BlogModel saveBlog(BlogModel blog) {
        return blogRepository.save(blog);
    }

    public List<BlogModel> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<BlogModel> blogByUser(Long userId) {
        return blogRepository.findByUserId(userId);
    }

    public BlogModel getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
