package br.com.fiap.bluepoints.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_PESSOA", uniqueConstraints = {
        /**
         * Uk para garantir que não se tenha mais de uma pessoa com o mesmo CPF.
         */
        @UniqueConstraint(name = "UK_TB_PESSOA_CPF", columnNames = {"CPF"})
})
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA")
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NM_PESSOA")
    private String nome;

    @Column(name = "SOBRENOME")
    private String sobrenome;

    @Column(name = "PONTOS")
    private Integer pontos;
}
