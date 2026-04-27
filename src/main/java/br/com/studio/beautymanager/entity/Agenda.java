package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agenda")
@Data
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studioId;

    private Long clienteId;

    private String servico;

    private LocalDateTime dataHora;

    private String status;
}