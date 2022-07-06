package com.its.test.service;

import com.its.test.dto.BoardDTO;
import com.its.test.entity.BoardEntity;
import com.its.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository br;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        Long id = br.save(boardEntity).getId();
        return id;
    }

    @Transactional
    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = br.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntity = br.findAll();
        List<BoardDTO> boardList = new ArrayList<>();
        for (BoardEntity board : boardEntity){
            boardList.add(BoardDTO.toBoardDTO(board));
        }
        return boardList;
    }

}