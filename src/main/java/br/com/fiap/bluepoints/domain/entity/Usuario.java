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
@Table(name = "TB_BP_USUARIO", uniqueConstraints = {
        /**
         * UK para garantir que não se tenha mais usernames iguais.
         * UK para garantir que não se tenha mais de um usuario vinculado a mesma pessoa.
         */
        @UniqueConstraint(name = "UK_BP_USUARIO_USERNAME", columnNames = {"EMAIL"}),
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_BP_USUARIO")
    @SequenceGenerator(name = "SQ_BP_USUARIO", sequenceName = "SQ_BP_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_BP_USUARIO_PESSOA"
            )
    )
    private Pessoa pessoa;

}

