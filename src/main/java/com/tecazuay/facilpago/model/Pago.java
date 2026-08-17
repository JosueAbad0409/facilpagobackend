package com.tecazuay.facilpago.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long idPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "anio_mes_pago", nullable = false, length = 7)
    private String anioMesPago;

    @Column(name = "valor_pago_alicuota", nullable = false)
    private Double valorPagoAlicuota;

    @Column(name = "valor_pago_consumo_servicios", nullable = false)
    private Double valorPagoConsumoServicios;

    @ManyToOne
    @JoinColumn(name = "cedula_condominio", nullable = false)
    private Condomino condomino;

    @ManyToOne
    @JoinColumn(name = "numero_departamento", nullable = false)
    private Departamento departamento;
}