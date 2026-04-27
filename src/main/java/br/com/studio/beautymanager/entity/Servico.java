package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "servico")
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studioId;

    private String nome;

    private Double valor;

    private Integer duracaoMinutos;

    private Boolean ativo;
}