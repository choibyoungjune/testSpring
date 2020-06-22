package com.sangkon.app.controller;


import com.sangkon.app.domain.Board;
import com.sangkon.app.service.BoardService;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String board(@PageableDefault Pageable pageable,Model model) {
        model.addAttribute("boardList", boardService.findBoardList(pageable));
        return "board/list";
    }

    @GetMapping("/board")
    public String getInputForm(Model model) {
        model.addAttribute("boardForm", new Board());
        return "board/form";
    }

    @PostMapping("/board")
    public String setInputForm(Board boardForm) {
        System.out.println(boardForm.getTitle());
        System.out.println(boardForm.getSubTitle());
        System.out.println(boardForm.getContent());
        System.out.println(boardForm.getBoardType());

        return "redirect:/board";
    }
}
