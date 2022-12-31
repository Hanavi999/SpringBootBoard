package com.example.jpaBoard.jpa.repository;

import com.example.jpaBoard.jpa.domain.BoardJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaRepository extends JpaRepository<BoardJpa, Integer> {
}
