package com.sparta.myblog2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FixRequestDto {
    private Long idGiven;
    private Long idInput;
    private String username;
    private String contents;
}
