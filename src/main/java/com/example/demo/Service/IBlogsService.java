package com.example.demo.Service;

import com.example.demo.Entity.Blogs;

import java.util.List;
import java.util.Optional;

public interface IBlogsService {
    Blogs createBlog(Blogs blog);

    List<Blogs> allBlogs();

    void deleteBlog(Long id);

    Optional<Blogs> updateBlog(Long id, Blogs blogToUpdate);

    Optional<Blogs> getBlog(Long id);
}
