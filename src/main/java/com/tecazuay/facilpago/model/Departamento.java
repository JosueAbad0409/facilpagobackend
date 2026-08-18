package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "El numero de departamento es obligatorio")
    @Column(name = "numero_departamento", nullable = false, unique = true, length = 20)
    private String numeroDepartamento;

    @NotBlank(message = "La descripcion es obligatoria")
    @Column(name = "descripcion_departamento", nullable = false, length = 100)
    private String descripcionDepartamento;

    @NotNull(message = "El bloque es obligatorio")
    @ManyToOne
    @JoinColumn(name = "bloque_id", nullable = false)
    private Bloque bloque;
}
