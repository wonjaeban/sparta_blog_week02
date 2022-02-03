package com.sparta.myblog2.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReplyRequestDto {
    private Long idInput;
    private String username;
    private String contents;
}
