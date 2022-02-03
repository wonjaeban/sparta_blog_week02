package com.sparta.myblog2.controller;

import com.sparta.myblog2.security.UserDetailsImpl;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    @Secured("ROLE_USER")
    @GetMapping("/index")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
            return "index";
        }
        catch (NullPointerException e) {
            return "index";
        }


    }

//    @Secured("ROLE_USER")
    @GetMapping("/upload")
    public String extrict(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
            return "upload";
        }
        catch (NullPointerException e) {
            return "upload";
        }
    }

    @GetMapping("/lookup")
    public String lookup(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        try {
            model.addAttribute("username", userDetails.getUsername());
            return "lookup";
        } catch (NullPointerException e) {
            return "lookup";
        }

    }

    @GetMapping("/lookup2")
    public String lookup2() {
        return "lookup";
    }


}
