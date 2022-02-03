package com.sparta.myblog2.repository;

import com.sparta.myblog2.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByIdInputOrderByCreatedAtDesc(Long idInput);
    void deleteById(Long id);
}
