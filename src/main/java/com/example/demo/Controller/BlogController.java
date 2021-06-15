package com.example.demo.Controller;

import com.example.demo.Entity.Blogs;
import com.example.demo.Service.BlogsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    @Autowired
    private BlogsServiceImpl blogsService;

    @PostMapping("/post")
    public ResponseEntity<Blogs> createBlog(@RequestBody Blogs newBlog){
        Blogs newBlogs = blogsService.createBlog(newBlog);

        return ResponseEntity.ok(newBlogs);
    }

    @GetMapping("/all")
    public List<Blogs> allBlogs(){
        return blogsService.allBlogs();
    }

    @DeleteMapping("/remove/{blogId}")
    private void deleteBlog(@PathVariable("blogId") Long Id){
        blogsService.deleteBlog(Id);
    }

    @GetMapping("find/{blogId}")
    private Optional<Blogs> getBlog(@PathVariable("blogId") Long Id){
        return blogsService.getBlog(Id);
    }

    @PutMapping("/update/{blogId}")
    private Optional<Blogs> updateBlog(@PathVariable("blogId") Long Id,
                                       @RequestBody Blogs blogToUpdate){
      return  blogsService.updateBlog(Id,blogToUpdate);
    }

}
