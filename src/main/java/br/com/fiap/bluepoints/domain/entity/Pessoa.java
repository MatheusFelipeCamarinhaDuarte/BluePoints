package br.com.fiap.bluepoints.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_BP_PESSOA")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_PESSOA")
    @SequenceGenerator(name = "SQ_BP_PESSOA", sequenceName = "SQ_BP_PESSOA", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "PONTOS")
    private Integer pontos;
}
