package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "condominos")
public class Condomino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "La cedula es obligatoria")
    @Column(name = "cedula_condominio", nullable = false, unique = true, length = 15)
    private String cedulaCondominio;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre_condomino", nullable = false, length = 50)
    private String nombreCondomino;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(name = "apellido_condomino", nullable = false, length = 50)
    private String apellidoCondomino;

    @Column(name = "celular_condomino", length = 15)
    private String celularCondomino;

    @Column(name = "telefono_condomino", length = 15)
    private String telefonoCondomino;

    // Se mantiene el bloque principal
    @NotNull(message = "El bloque es obligatorio")
    @ManyToOne
    @JoinColumn(name = "bloque_id", nullable = false)
    private Bloque bloque;

    @ManyToMany
    @JoinTable(
            name = "condominos_departamentos",
            joinColumns = @JoinColumn(name = "condomino_id"),
            inverseJoinColumns = @JoinColumn(name = "departamento_id")
    )
    private List<Departamento> departamentos;
}
