package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "departamentos")
public class Departamento {

    @Id
    @Column(name = "numero_departamento", length = 20)
    private String numeroDepartamento;

    @Column(name = "descripcion_departamento", nullable = false, length = 100)
    private String descripcionDepartamento;
    
    @ManyToOne
    @JoinColumn(name = "numero_bloque", nullable = false)
    private Bloque bloque;
}