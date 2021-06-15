package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.Util.JwtUtil;
import com.example.demo.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User user){

        Long id = userService.saveUser(user);
        String body = String.format("User %s saved successfully 🤪🤪🤪🤪",id);


        return  ResponseEntity.ok(body);
    }

    //validate user and generate token
    @PostMapping("/login")
     public ResponseEntity<UserResponse>  loginUser(@NotNull @RequestBody User userRequest){

        //TODO : validate usern /pass with db
        String token = jwtUtil.generateToken(userRequest.getUsername());
        return ResponseEntity.ok(new UserResponse(token,"Success 🥳🥳🥳🥳"));
     }
}
