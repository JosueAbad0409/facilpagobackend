package com.tecazuay.facilpago.controller;

import com.tecazuay.facilpago.model.Pago;
import com.tecazuay.facilpago.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private IPagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> listarPagos() {
        return new ResponseEntity<>(pagoService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        return new ResponseEntity<>(pagoService.guardar(pago), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.obtenerPorId(id)
                .map(p -> {
                    pago.setIdPago(id);
                    return new ResponseEntity<>(pagoService.guardar(pago), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        if (pagoService.obtenerPorId(id).isPresent()) {
            pagoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}