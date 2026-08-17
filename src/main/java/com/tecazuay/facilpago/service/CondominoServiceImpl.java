package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Condomino;
import com.tecazuay.facilpago.repository.CondominoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CondominoServiceImpl implements ICondominoService {

    @Autowired
    private CondominoRepository condominoRepository;

    @Override
    public List<Condomino> listarTodos() {
        return condominoRepository.findAll();
    }

    @Override
    public Optional<Condomino> obtenerPorId(String id) {
        return condominoRepository.findById(id);
    }

    @Override
    public Condomino guardar(Condomino condomino) {
        return condominoRepository.save(condomino);
    }

    @Override
    public void eliminar(String id) {
        condominoRepository.deleteById(id);
    }
}