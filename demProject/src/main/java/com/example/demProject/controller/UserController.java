package com.example.demProject.controller;

import com.example.demProject.dto.UserEntityDto;
import com.example.demProject.entity.UserEntity;
import com.example.demProject.mapper.UserEntityMapper;
import com.example.demProject.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService, AuthenticationManager authenticationManager, UserEntityMapper userEntityMapper) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Object> register(@RequestBody UserEntityDto userEntityDto) {
        return userService.register(userEntityDto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String login(@RequestBody UserEntityDto userEntityDto) {
        return userService.verify(userEntityDto);
    }


    @GetMapping("csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
