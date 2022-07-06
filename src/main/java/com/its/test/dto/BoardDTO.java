package com.its.test.dto;

import com.its.test.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime createdTime;

    public BoardDTO(Long id, String boardTitle, String boardWriter, int boardHits, LocalDateTime createdTime, String boardContents) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardHits = boardHits;
        this.createdTime = createdTime;
    }

    public BoardDTO(Long id, String boardTitle, String boardWriter) {
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoard_writer());
        boardDTO.setBoardTitle(boardEntity.getBoard_title());
        boardDTO.setBoardContents(boardEntity.getBoard_contents());
        boardDTO.setBoardHits(boardEntity.getBoard_hits());
        boardDTO.setCreatedTime(boardEntity.getBoard_created_time());
        return boardDTO;
    }
    public BoardDTO(String boardTitle, String boardWriter, int boardHits, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardWriter = boardWriter;
        this.boardContents = boardContents;
        this.boardHits = boardHits;
    }


}
