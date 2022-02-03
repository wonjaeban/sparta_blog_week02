package com.sparta.myblog2.model;


import com.sparta.myblog2.dto.MemoRequestDto;
import com.sparta.myblog2.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Reply extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long idInput;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Reply(String username, String contents, Long idInput) {
        this.username = username;
        this.contents = contents;
        this.idInput = idInput;
    }
    public Reply(ReplyRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.idInput = requestDto.getIdInput();
    }

    public void update(ReplyRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.idInput = requestDto.getIdInput();
    }
}
