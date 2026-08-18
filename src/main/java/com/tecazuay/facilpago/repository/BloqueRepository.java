package com.tecazuay.facilpago.repository;

import com.tecazuay.facilpago.model.Bloque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueRepository extends JpaRepository<Bloque, Long> {

}
