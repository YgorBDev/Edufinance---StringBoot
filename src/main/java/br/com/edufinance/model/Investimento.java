package br.com.edufinance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "investimentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeAtivo;

    private String ticker;

    private String tipo;

    private String risco;

    private Double precoAtual;

    private Double rentabilidadeAnual;
}