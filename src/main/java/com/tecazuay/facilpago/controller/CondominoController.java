package com.tecazuay.facilpago.controller;

import com.tecazuay.facilpago.model.Condomino;
import com.tecazuay.facilpago.service.ICondominoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condominos")
@CrossOrigin(origins = "*")
public class CondominoController {

    @Autowired
    private ICondominoService condominoService;

    @GetMapping
    public ResponseEntity<List<Condomino>> listarCondominos() {
        return new ResponseEntity<>(condominoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condomino> obtenerCondomino(@PathVariable Long id) {
        return condominoService.obtenerPorId(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Condomino> crearCondomino(@Valid @RequestBody Condomino condomino) {
        return new ResponseEntity<>(condominoService.guardar(condomino), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condomino> actualizarCondomino(@PathVariable Long id, @Valid @RequestBody Condomino condomino) {
        if (condominoService.obtenerPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        condomino.setId(id);
        return new ResponseEntity<>(condominoService.guardar(condomino), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCondomino(@PathVariable Long id) {
        if (condominoService.obtenerPorId(id).isPresent()) {
            condominoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
