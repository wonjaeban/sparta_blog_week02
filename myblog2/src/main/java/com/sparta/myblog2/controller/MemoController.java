package com.sparta.myblog2.controller;

import com.sparta.myblog2.dto.DeleteRequestDto;
import com.sparta.myblog2.dto.FixRequestDto;
import com.sparta.myblog2.dto.ReplyRequestDto;
import com.sparta.myblog2.model.Memo;
import com.sparta.myblog2.model.Reply;
import com.sparta.myblog2.repository.MemoRepository;
import com.sparta.myblog2.dto.MemoRequestDto;
import com.sparta.myblog2.repository.ReplyRepository;
import com.sparta.myblog2.service.MemoService;
import com.sparta.myblog2.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final ReplyRepository replyRepository;
    private final ReplyService replyService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/lookup")
    public Optional<Memo> getLookup(@RequestParam(value="id") Long idInput) {
        return memoRepository.findById(idInput);

    }

    @GetMapping("/api/lookup/reply")
    public List<Reply> getReply(@RequestParam(value="id") Long idInput) {
        return replyRepository.findByIdInputOrderByCreatedAtDesc(idInput);

    }


//    @Secured("ROLE_USER")
    @PostMapping("/api/replies")
    public Reply createReply(@RequestBody ReplyRequestDto replyRequestDto) {
        Reply reply = new Reply(replyRequestDto);
        return replyRepository.save(reply);
    }

//    @Secured("ROLE_USER")
    @PostMapping("/api/replies/fixing")
    public void fixReply(@RequestBody FixRequestDto fixRequestDto) {
        Long id = fixRequestDto.getIdGiven();
        replyService.update(id, fixRequestDto);
    }

//    @Secured("ROLE_USER")
    @PostMapping("/api/replies/deleting")
    public void deleteReply(@RequestBody DeleteRequestDto deleteRequestDto) {
        Long id = deleteRequestDto.getIdGiven();
        replyService.delete(id);
    }



}