package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "agenda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_id")
    private Long studioId;

    @Column(name = "servico_id")
    private Long servicoId;

    private String cliente;

    private String servico;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    private String status; // AGENDADO, CANCELADO, FINALIZADO

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
    private List<AgendaServico> servicos;
    }