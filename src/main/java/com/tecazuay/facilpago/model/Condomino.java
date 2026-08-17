package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "condominos")
public class Condomino {

    @Id
    @Column(name = "cedula_condominio", length = 15)
    private String cedulaCondominio;

    @Column(name = "nombre_condomino", nullable = false, length = 50)
    private String nombreCondomino;

    @Column(name = "apellido_condomino", nullable = false, length = 50)
    private String apellidoCondomino;

    @Column(name = "celular_condomino", length = 15)
    private String celularCondomino;

    @Column(name = "telefono_condomino", length = 15)
    private String telefonoCondomino;

    // Se mantiene el bloque principal
    @ManyToOne
    @JoinColumn(name = "numero_bloque", nullable = false)
    private Bloque bloque;


    @ManyToMany
    @JoinTable(
            name = "condominos_departamentos",
            joinColumns = @JoinColumn(name = "cedula_condominio"),
            inverseJoinColumns = @JoinColumn(name = "numero_departamento")
    )
    private List<Departamento> departamentos;
}