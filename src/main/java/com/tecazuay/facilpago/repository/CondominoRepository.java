package com.tecazuay.facilpago.repository;

import com.tecazuay.facilpago.model.Condomino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominoRepository extends JpaRepository<Condomino, String> {
}