package com.tecazuay.facilpago.controller;

import com.tecazuay.facilpago.model.Bloque;
import com.tecazuay.facilpago.service.IBloqueService;
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

    @PostMapping
    public ResponseEntity<Bloque> crearBloque(@RequestBody Bloque bloque) {
        return new ResponseEntity<>(bloqueService.guardar(bloque), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloque> actualizarBloque(@PathVariable String id, @RequestBody Bloque bloque) {
        return bloqueService.obtenerPorId(id)
                .map(b -> {
                    bloque.setNumeroBloque(id);
                    return new ResponseEntity<>(bloqueService.guardar(bloque), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBloque(@PathVariable String id) {
        if (bloqueService.obtenerPorId(id).isPresent()) {
            bloqueService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}