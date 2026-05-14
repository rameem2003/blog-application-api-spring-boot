package com.rameem.blogapi.services;

import java.util.List;
import java.util.Optional;

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
        System.out.println("Getting all blogs");
        return blogRepository.findAll();
    }

    public List<BlogModel> getBlogsByUserId(Long userId) {
        return blogRepository.findByUserId(userId);
    }

    public BlogModel getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    public BlogModel updateBlog(Long id, BlogModel updatedBlog) {

        Optional<BlogModel> optionalBlog = blogRepository.findById(id);

        if (optionalBlog.isPresent()) {

            BlogModel existingBlog = optionalBlog.get();

            existingBlog.setTitle(updatedBlog.getTitle());
            existingBlog.setContent(updatedBlog.getContent());

            if (updatedBlog.getUser() != null) {
                existingBlog.setUser(updatedBlog.getUser());
            }

            return blogRepository.save(existingBlog);
        }

        return null;
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
