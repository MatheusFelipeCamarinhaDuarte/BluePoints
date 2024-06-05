package br.com.fiap.bluepoints.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_BP_FOTO")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_FOTO")
    @SequenceGenerator( name = "SQ_BP_FOTO", sequenceName = "SQ_BP_FOTO", allocationSize = 1)
    @Column(name = "ID_FOTO")
    private Long id;

    private String src;

}