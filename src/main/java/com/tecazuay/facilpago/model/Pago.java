package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "La fecha de pago es obligatoria")
    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @NotNull(message = "El anio-mes de pago es obligatorio")
    @Column(name = "anio_mes_pago", nullable = false, length = 7)
    private String anioMesPago;

    @NotNull(message = "El valor de la alicuota es obligatorio")
    @Column(name = "valor_pago_alicuota", nullable = false)
    private Double valorPagoAlicuota;

    @NotNull(message = "El valor de consumo de servicios es obligatorio")
    @Column(name = "valor_pago_consumo_servicios", nullable = false)
    private Double valorPagoConsumoServicios;

    @NotNull(message = "El condomino es obligatorio")
    @ManyToOne
    @JoinColumn(name = "condomino_id", nullable = false)
    private Condomino condomino;

    @NotNull(message = "El departamento es obligatorio")
    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;
}
