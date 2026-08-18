package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "bloques")
public class Bloque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El numero de bloque es obligatorio")
    @Column(name = "numero_bloque", nullable = false, unique = true, length = 10)
    private String numeroBloque;

    @NotBlank(message = "La descripcion es obligatoria")
    @Column(name = "descripcion_bloque", nullable = false, length = 100)
    private String descripcionBloque;

    @NotBlank(message = "La ubicacion es obligatoria")
    @Column(name = "ubicacion", nullable = false, length = 100)
    private String ubicacion;
}
