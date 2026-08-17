package com.tecazuay.facilpago.service;

import com.tecazuay.facilpago.model.Bloque;
import com.tecazuay.facilpago.repository.BloqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // La anotación va en la implementación, no en la interfaz
public class BloqueServiceImpl implements IBloqueService {

    @Autowired
    private BloqueRepository bloqueRepository;

    @Override
    public List<Bloque> listarTodos() {
        return bloqueRepository.findAll();
    }

    @Override
    public Optional<Bloque> obtenerPorId(String id) {
        return bloqueRepository.findById(id);
    }

    @Override
    public Bloque guardar(Bloque bloque) {
        return bloqueRepository.save(bloque);
    }

    @Override
    public void eliminar(String id) {
        bloqueRepository.deleteById(id);
    }
}