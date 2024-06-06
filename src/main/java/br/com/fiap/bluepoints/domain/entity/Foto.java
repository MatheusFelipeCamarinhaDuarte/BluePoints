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
@Table(name = "TB_BP_FOTO")
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_FOTO")
    @SequenceGenerator(name = "SQ_BP_FOTO", sequenceName = "SQ_BP_FOTO", allocationSize = 1)
    @Column(name = "ID_FOTO")
    private Long id;

    @Column(name = "SRC")
    private String src;
}
