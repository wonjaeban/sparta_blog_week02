package com.sparta.myblog2.service;

import com.sparta.myblog2.dto.FixRequestDto;
import com.sparta.myblog2.dto.MemoRequestDto;
import com.sparta.myblog2.dto.ReplyRequestDto;
import com.sparta.myblog2.model.Memo;
import com.sparta.myblog2.model.Reply;
import com.sparta.myblog2.repository.MemoRepository;
import com.sparta.myblog2.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    @Transactional
    public void update(Long id, FixRequestDto requestDto) {
        Reply reply = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        ReplyRequestDto replyRequestDto = new ReplyRequestDto();
        replyRequestDto.setContents(requestDto.getContents());
        replyRequestDto.setUsername(requestDto.getUsername());
        replyRequestDto.setIdInput(requestDto.getIdInput());
        reply.update(replyRequestDto);
    }

    @Transactional
    public void delete(Long id) {
        Reply reply = replyRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        replyRepository.deleteById(id);
    }



}
