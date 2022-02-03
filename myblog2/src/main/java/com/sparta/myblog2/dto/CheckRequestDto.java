package com.sparta.myblog2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckRequestDto {
    private Long idInput;
    private String username;
}
