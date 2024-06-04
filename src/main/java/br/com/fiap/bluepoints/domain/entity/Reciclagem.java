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
@Table(name = "TB_RECICLAGEM", uniqueConstraints = {
        /**
         * Uk para garantir que não se tenha mais de uma mesma foto.
         */
        @UniqueConstraint(name = "UK_TB_RECICLAGEM_FOTO", columnNames = {"FOTO"})
})
public class Reciclagem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RECICLAGEM")
    @SequenceGenerator(name = "SQ_RECICLAGEM")
    @Column(name = "ID_RECICLAGEM")
    private Long id;

    @Column(name = "PONTOS")
    private Integer pontos;


    @Column(name = "VALIDADO")
    private Boolean isValidado;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_RECICLAGEM_PESSOA"
            )
    )
    private Pessoa pessoa;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "FOTO",
            referencedColumnName = "ID_FOTO",
            foreignKey = @ForeignKey(
                    name = "FK_RECICLAGEM_FOTO"
            )
    )
    private Foto foto;
}
