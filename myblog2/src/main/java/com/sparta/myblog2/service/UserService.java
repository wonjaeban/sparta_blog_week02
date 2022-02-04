package com.sparta.myblog2.service;

import com.sparta.myblog2.dto.SignupRequestDto;
import com.sparta.myblog2.model.User;
import com.sparta.myblog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(SignupRequestDto requestDto) {
// 회원 ID 중복 확인
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();
        String rePassword = requestDto.getReconfirmPassword();
        String pattern = "^[A-Za-z0-9]*$";
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            return "true1";
        }
        else if (username.length() < 3) {
            return "true2";
        }
        else if (!Pattern.matches(pattern, username)) {
            return "true3";
        }
        else if (password.length() < 4) {
            return "true4";
        }
        else if (password.contains(username)) {
            return "true5";
        }
        else if (!password.equals(rePassword)) {
            return "true6";
        }
        else {
            // 패스워드 암호화
            String password2 = passwordEncoder.encode(requestDto.getPassword());
            String ReconfirmPassword = passwordEncoder.encode(requestDto.getReconfirmPassword());


            User user = new User(username, password2, ReconfirmPassword);
            userRepository.save(user);
            return "false";
        }
    }

}
