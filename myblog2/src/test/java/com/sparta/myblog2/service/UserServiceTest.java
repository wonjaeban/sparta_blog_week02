package com.sparta.myblog2.service;

import com.sparta.myblog2.model.User;
import com.sparta.myblog2.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserRepository userRepository;

    @Test
    @DisplayName("아이디 중복 O, 아이디 정상, 비밀번호 정상, 비밀번호 확인 정상")
    void doubleUser() {
        String username = "qwer";
        String password2 = "dnjswo";
        String ReconfirmPassword = "dnjswo";

        String pattern = "^[A-Za-z0-9]*$";
        User user = new User(username, password2, ReconfirmPassword);

        when(userRepository.findByUsername(username))
                .thenReturn(Optional.of(user));

        Optional<User> found = userRepository.findByUsername(username);

        assertEquals(true, found.isPresent());
        assertEquals(false, username.length() < 3);
        assertEquals(false, !Pattern.matches(pattern, username));
        assertEquals(false, password2.length() < 4);
        assertEquals(false, password2.contains(username));
        assertEquals(false, !password2.equals(ReconfirmPassword));

    }


    @Test
    @DisplayName("아이디 중복 X, 아이디 정상, 비밀번호 정상, 비밀번호 확인 정상")
    void IsTrue() {
        String username = "qsdfds";
        String password2 = "dnjswo";
        String ReconfirmPassword = "dnjswo";

        String pattern = "^[A-Za-z0-9]*$";

        when(userRepository.findByUsername(username))
                .thenReturn(null);

        Optional<User> found = userRepository.findByUsername(username);
        try {
            found.isPresent();
        } catch (NullPointerException e) {
            assertEquals(false, false);
        }

        assertEquals(false, username.length() < 3);
        assertEquals(false, !Pattern.matches(pattern, username));
        assertEquals(false, password2.length() < 4);
        assertEquals(false, password2.contains(username));
        assertEquals(false, !password2.equals(ReconfirmPassword));

    }

    @Test
    @DisplayName("아이디 중복 X, 아이디 3자미만, 비밀번호 4자미만, 비밀번호 확인 불일치")
    void IsFalse() {
        String username = "qs";
        String password2 = "dnc";
        String ReconfirmPassword = "dnjswo";

        String pattern = "^[A-Za-z0-9]*$";

        when(userRepository.findByUsername(username))
                .thenReturn(null);

        Optional<User> found = userRepository.findByUsername(username);
        try {
            found.isPresent();
        } catch (NullPointerException e) {
            assertEquals(false, false);
        }

        assertEquals(true, username.length() < 3);
        assertEquals(false, !Pattern.matches(pattern, username));
        assertEquals(true, password2.length() < 4);
        assertEquals(false, password2.contains(username));
        assertEquals(true, !password2.equals(ReconfirmPassword));

    }

    @Test
    @DisplayName("아이디 중복 X, 아이디 한글포함, 비밀번호 닉네임과 같은 값 존재, 비밀번호 확인 일치")
    void IsFalse2() {
        String username = "qwerㅂㅈ";
        String password2 = "qwerㅂㅈdnjswo";
        String ReconfirmPassword = "qwerㅂㅈdnjswo";

        String pattern = "^[A-Za-z0-9]*$";

        when(userRepository.findByUsername(username))
                .thenReturn(null);

        Optional<User> found = userRepository.findByUsername(username);
        try {
            found.isPresent();
        } catch (NullPointerException e) {
            assertEquals(false, false);
        }

        assertEquals(false, username.length() < 3);
        assertEquals(true, !Pattern.matches(pattern, username));
        assertEquals(false, password2.length() < 4);
        assertEquals(true, password2.contains(username));
        assertEquals(false, !password2.equals(ReconfirmPassword));

    }
}
