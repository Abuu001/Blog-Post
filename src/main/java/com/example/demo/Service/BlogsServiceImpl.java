package com.example.demo.Service;

import com.example.demo.Entity.Blogs;
import com.example.demo.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogsServiceImpl implements IBlogsService{

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blogs createBlog(Blogs blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blogs> allBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlog(Long id) {

      blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blogs> updateBlog(Long id, Blogs blogToUpdate) {
       Optional<Blogs> oldBlog = blogRepository.findById(id);

        if(oldBlog.isPresent()){
            oldBlog.get().setComment(blogToUpdate.getComment());
            oldBlog.get().setCreatedAt(blogToUpdate.getCreatedAt());
            oldBlog.get().setTitle(blogToUpdate.getTitle());

        }

        return  oldBlog;
    }

    @Override
    public Optional<Blogs> getBlog(Long id) {

        return blogRepository.findById(id);
    }
}
