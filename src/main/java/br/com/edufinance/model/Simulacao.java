package br.com.edufinance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "simulacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;

    private Double valorInicial;

    private Double aporteMensal;

    private Integer prazoMeses;

    private Double rentabilidadeAnual;

    private Double valorFinal;

    private LocalDate dataSimulacao;
}