package com.its.test.controller;

import com.its.test.dto.BoardDTO;
import com.its.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService bs;
    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
        bs.save(boardDTO);
        return "redirect:/" +boardDTO.getId();
    }
    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        BoardDTO boardDTO = bs.findById(id);
        model.addAttribute("board",boardDTO);
        return "detail";
    }
}
