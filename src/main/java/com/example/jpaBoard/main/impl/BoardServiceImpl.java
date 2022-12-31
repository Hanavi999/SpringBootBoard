package com.example.jpaBoard.main.impl;

import com.example.jpaBoard.jpa.domain.BoardJpa;
import com.example.jpaBoard.jpa.domain.dto.BoardDto;
import com.example.jpaBoard.jpa.domain.dto.BoardTemp;
import com.example.jpaBoard.jpa.repository.BoardJpaRepository;
import com.example.jpaBoard.service.BoardSerivce;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardSerivce {

    @Autowired
    private BoardJpaRepository boardJpaRepository;

    @Override
    public void writeBoard(BoardJpa boardJpa) {
        boardJpaRepository.save(boardJpa);
    }

    @Override
    public List<BoardJpa> boardList() {
        return boardJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public BoardJpa boardView(Integer id) {
        return boardJpaRepository.findById(id).get();
    }

    @Override
    public Message deleteBoard(BoardDto boardDto) {
        BoardJpa boardJpa = boardJpaRepository.findById(boardDto.getId()).orElse(null);
        if(boardJpa.getPasswd().equals(boardDto.getPasswd())) {
            boardJpaRepository.delete(boardJpa);
        }
        return null;
    }

    @Override
    public Message modifyBoard(BoardTemp boardTemp) {

        BoardJpa boardJpa = boardJpaRepository.findById(boardTemp.getId()).orElse(null);
        if(boardJpa.getPasswd().equals(boardTemp.getPasswd())) {
            boardJpa.setTitle(boardTemp.getTitle());
            boardJpa.setContent(boardTemp.getContent());
            boardJpa.setName(boardTemp.getName());
            boardJpa.setPasswd(boardTemp.getPasswd());
            boardJpaRepository.save(boardJpa);
        }

        return null;

    }

}
