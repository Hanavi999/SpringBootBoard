package com.example.jpaBoard.service;

import com.example.jpaBoard.jpa.domain.BoardJpa;
import com.example.jpaBoard.jpa.domain.dto.BoardDto;
import com.example.jpaBoard.jpa.domain.dto.BoardTemp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardSerivce {

    void writeBoard(BoardJpa boardJpa);

    List<BoardJpa> boardList();

    BoardJpa boardView(Integer id);

    Object deleteBoard(BoardDto boardDto);

    Object modifyBoard(BoardTemp boardTemp);

}
