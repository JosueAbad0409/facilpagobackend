package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Departamento;
import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    List<Departamento> listarTodos();
    Optional<Departamento> obtenerPorId(Long id);
    Departamento guardar(Departamento departamento);
    void eliminar(Long id);
}
