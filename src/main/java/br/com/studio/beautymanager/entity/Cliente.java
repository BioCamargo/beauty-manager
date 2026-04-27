package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "cliente")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studioId;

    private String nome;

    private String telefone;

    private String email;

    private Boolean ativo;
}