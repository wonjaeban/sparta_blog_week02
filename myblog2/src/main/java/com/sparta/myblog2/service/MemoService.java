package com.sparta.myblog2.service;

import com.sparta.myblog2.model.Memo;
import com.sparta.myblog2.model.User;
import com.sparta.myblog2.repository.MemoRepository;
import com.sparta.myblog2.dto.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {
    private final MemoRepository memoRepository;
    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }

    public boolean check(Long idInput) {
        Optional<Memo> found = memoRepository.findById(idInput);
        if (found.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
