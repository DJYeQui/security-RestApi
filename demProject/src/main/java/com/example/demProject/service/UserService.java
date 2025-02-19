package com.example.demProject.service;

import com.example.demProject.config.SecurityConfig;
import com.example.demProject.dto.UserEntityDto;
import com.example.demProject.entity.UserEntity;
import com.example.demProject.mapper.UserEntityMapper;
import com.example.demProject.repository.UserEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;
    private final SecurityConfig securityConfig;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<Object> register(UserEntityDto user) {
        UserEntity userEntity = userEntityMapper.toEntity(user);
        //Crypt Password
        userEntity.setPassword(securityConfig.getBCryptPasswordEncoder().encode(user.getPassword()));
        userEntityRepository.save(userEntity);
        return ResponseEntity.ok(userEntity);
    }

    public String verify(UserEntityDto userEntityDto) throws UsernameNotFoundException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntityDto.getUsername(),userEntityDto.getPassword()));
        if (authentication.isAuthenticated()) return authentication.getName();
        return "false login";

    }
}
