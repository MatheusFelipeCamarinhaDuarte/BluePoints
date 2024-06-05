package br.com.fiap.bluepoints.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_BP_PREMIO", uniqueConstraints = {
        /**
         * UK para garantir que não se tenha mais de um premio com o mesmo nome.
         */
        @UniqueConstraint(name = "UK_TB_BP_PREMIO_NM", columnNames = {"NM_PREMIO"})
})
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_PREMIO")
    @SequenceGenerator(name = "SQ_BP_PREMIO", sequenceName = "SQ_BP_PREMIO", allocationSize = 1)
    @Column(name = "ID_PREMIO")
    private Long id;

    @Column(name = "NM_PREMIO")
    private String nome;

    @Column(name = "CUSTO")
    private Integer custo;
}
