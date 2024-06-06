package br.com.fiap.bluepoints.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_BP_RECICLAGEM", uniqueConstraints = {
        /**
         * Uk para garantir que não se tenha mais de uma mesma foto.
         */
        @UniqueConstraint(name = "UK_TB_BP_RECICLAGEM_FOTO", columnNames = {"FOTO"})
})
public class Reciclagem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_RECICLAGEM")
    @SequenceGenerator(name = "SQ_BP_RECICLAGEM", sequenceName = "SQ_BP_RECICLAGEM", allocationSize = 1)
    @Column(name = "ID_RECICLAGEM")
    private Long id;

    @Column(name = "PONTOS")
    private Integer pontos;


    @Column(name = "VALIDADO")
    private Boolean isValidado = false;

    @Column(name = "MOMENTO")
    private LocalDateTime momento;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "FK_BP_RECICLAGEM_USUARIO"
            )
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "FOTO",
            referencedColumnName = "ID_FOTO",
            foreignKey = @ForeignKey(
                    name = "FK_BP_RECICLAGEM_FOTO"
            )
    )
    private Foto foto;
}
