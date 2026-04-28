package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_id")
    private Long studioId;

    private String nome;

    private String telefone;

    private String email;

    private String observacao;

    private Boolean ativo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}