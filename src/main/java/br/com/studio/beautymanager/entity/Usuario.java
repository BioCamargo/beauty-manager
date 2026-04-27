package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_id")
    private Long studioId;

    private String nome;

    private String email;

    private String senha;

    private String tipo;

    private Boolean ativo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}