package com.its.test.entity;

import com.its.test.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter @Setter
@Table(name= "board_table")
public class BoardEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "board_id")
    private Long id;

    @Column(length = 30, nullable = false)
    private String board_writer;

    @Column(length = 50, nullable = false)
    private String board_title;

    @Column(length = 500)
    private String board_contents;

    @Column
    private int board_hits;

    @Column
    private LocalDateTime board_created_time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;


    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoard_title(boardDTO.getBoardTitle());
        boardEntity.setBoard_writer(boardDTO.getBoardWriter());
        boardEntity.setBoard_contents(boardDTO.getBoardContents());
        boardEntity.setBoard_hits(0);
        return boardEntity;
    }

}
