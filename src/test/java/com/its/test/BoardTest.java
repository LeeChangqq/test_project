package com.its.test;

import com.its.test.dto.BoardDTO;
import com.its.test.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class BoardTest {
    @Autowired
    BoardService boardService;

    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("회원가입 테스트")
    public void boardSaveTest() {
        Long id = boardService.save(new BoardDTO("a1","a2",1,"a3"));
        BoardDTO board = boardService.findById(id);
        assertThat("a2").isEqualTo(board.getBoardWriter());
    }
}
