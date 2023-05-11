package com.bookstore.usersservice.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bookstore.usersservice.model.UserDTO;
import com.bookstore.usersservice.repository.User;
import com.bookstore.usersservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public UserDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);
        UserDTO dto = new UserDTO();
        if(user !=null) {
            BeanUtils.copyProperties(user, dto);
            if(passwordEncoder.matches(password, dto.getPassword())) {
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withClaim("role", user.getRole())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ (1 * 60 * 10000)))
                        .sign(algorithm);
                String refreshtoken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ (10080 * 60 * 10000)))
                        .sign(algorithm);
                dto.setToken(access_token);
                dto.setRefreshtoken(refreshtoken);
            }
        }
        return dto;
    }
}
