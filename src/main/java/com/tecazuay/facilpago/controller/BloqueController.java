package com.tecazuay.facilpago.controller;

import com.tecazuay.facilpago.model.Bloque;
import com.tecazuay.facilpago.service.IBloqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloques")
@CrossOrigin(origins = "*")
public class BloqueController {

    @Autowired
    private IBloqueService bloqueService;

    @GetMapping
    public ResponseEntity<List<Bloque>> listarBloques() {
        return new ResponseEntity<>(bloqueService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloque> obtenerBloque(@PathVariable Long id) {
        return bloqueService.obtenerPorId(id)
                .map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Bloque> crearBloque(@Valid @RequestBody Bloque bloque) {
        return new ResponseEntity<>(bloqueService.guardar(bloque), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloque> actualizarBloque(@PathVariable Long id, @Valid @RequestBody Bloque bloque) {
        if (bloqueService.obtenerPorId(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bloque.setId(id);
        return new ResponseEntity<>(bloqueService.guardar(bloque), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBloque(@PathVariable Long id) {
        if (bloqueService.obtenerPorId(id).isPresent()) {
            bloqueService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
