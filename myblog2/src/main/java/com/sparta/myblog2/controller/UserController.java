package com.sparta.myblog2.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.myblog2.dto.SignupRequestDto;
import com.sparta.myblog2.security.UserDetailsImpl;
import com.sparta.myblog2.service.KakaoUserService;
import com.sparta.myblog2.service.MemoService;
import com.sparta.myblog2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;
    private final KakaoUserService kakaoUserService;
    private final MemoService memoService;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService, MemoService memoService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
        this.memoService = memoService;
    }

    // 회원 로그인 페이지
    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
            return "login";
        } catch (NullPointerException e) {
            return "login";
        }
    }

    // 회원 가입 페이지
    @GetMapping("/signup")
    public String signup(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
            return "signup";
        } catch (NullPointerException e) {
            return "signup";
        }
    }

    // 회원 가입 요청 처리
    @PostMapping("/signup")
    public String registerUser(Model model, SignupRequestDto requestDto) {

        boolean TorF = userService.registerUser(requestDto);
        if (TorF == false) {
            return "redirect:/login";
        }
        else {
            return "redirect:/signup?error";
        }

    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
// authorizedCode: 카카오 서버로부터 받은 인가 코드
        kakaoUserService.kakaoLogin(code);

        return "redirect:/index";
    }
}
