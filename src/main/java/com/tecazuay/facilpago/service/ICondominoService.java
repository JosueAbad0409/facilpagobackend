package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Condomino;
import java.util.List;
import java.util.Optional;

public interface ICondominoService {
    List<Condomino> listarTodos();
    Optional<Condomino> obtenerPorId(String id);
    Condomino guardar(Condomino condomino);
    void eliminar(String id);
}