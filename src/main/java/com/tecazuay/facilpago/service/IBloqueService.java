package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Bloque;
import java.util.List;
import java.util.Optional;

public interface IBloqueService {
    List<Bloque> listarTodos();
    Optional<Bloque> obtenerPorId(Long id);
    Bloque guardar(Bloque bloque);
    void eliminar(Long id);
}
