package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Pago;
import java.util.List;
import java.util.Optional;

public interface IPagoService {
    List<Pago> listarTodos();
    Optional<Pago> obtenerPorId(Long id);
    Pago guardar(Pago pago);
    void eliminar(Long id);
}