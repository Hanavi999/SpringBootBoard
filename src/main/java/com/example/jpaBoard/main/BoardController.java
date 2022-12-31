package com.example.jpaBoard.main;

import com.example.jpaBoard.jpa.domain.BoardJpa;
import com.example.jpaBoard.jpa.domain.dto.BoardDto;
import com.example.jpaBoard.jpa.domain.dto.BoardTemp;
import com.example.jpaBoard.jpa.repository.BoardJpaRepository;
import com.example.jpaBoard.main.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @Autowired
    private BoardServiceImpl boardService;
    @Autowired
    private BoardJpaRepository boardJpaRepository;


    @GetMapping("/")
    public String main(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "main";
    }

    @GetMapping("/input")
    public String input() {
        return "input";
    }

    @PostMapping("/inputOk")
    public String inputOk(BoardJpa boardJpa) {
        boardService.writeBoard(boardJpa);
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(Model model, Integer id) {
        model.addAttribute("board", boardService.boardView(id));
        return "view";
    }

    @PostMapping("/del")
    public String del(BoardDto boardDto, Model model) {
        model.addAttribute("data", boardService.deleteBoard(boardDto));
        return "redirect:/";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable("id") Integer id, Model model ) {

        model.addAttribute("board", boardService.boardView(id));

        return "modify";
    }

    @PostMapping("/modifyOk/{id}")
    public String modifyOk(@PathVariable("id") Integer id, Model model, BoardTemp boardTemp, BoardJpa boardJpa) {

        boardTemp.setId(boardJpa.getId());
        boardTemp.setTitle(boardJpa.getTitle());
        boardTemp.setContent(boardJpa.getContent());
        boardTemp.setName(boardJpa.getName());
        boardTemp.setPasswd(boardJpa.getPasswd());

        model.addAttribute("data", boardService.modifyBoard(boardTemp));
        return "redirect:/";
    }

}
