package com.sparta.myblog2.service;

import com.sparta.myblog2.dto.SignupRequestDto;
import com.sparta.myblog2.model.User;
import com.sparta.myblog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(SignupRequestDto requestDto) {
// 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return true;
        }
        else {
            // 패스워드 암호화
            String password = passwordEncoder.encode(requestDto.getPassword());
            String ReconfirmPassword = passwordEncoder.encode(requestDto.getReconfirmPassword());


            User user = new User(username, password, ReconfirmPassword);
            userRepository.save(user);
            return false;
        }
    }

    @Transactional
    public boolean check(String username) {
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return true;
        } else {
            return false;
        }
    }

}
