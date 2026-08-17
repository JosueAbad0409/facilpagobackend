package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bloques")
public class Bloque {

    @Id
    @Column(name = "numero_bloque", length = 10)
    private String numeroBloque;

    @Column(name = "descripcion_bloque", nullable = false, length = 100)
    private String descripcionBloque;

    @Column(name = "ubicacion", nullable = false, length = 100)
    private String ubicacion;
}