package br.com.studio.beautymanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "studio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio_id")
    private Long studioId;
    
    private String nome;

    private String telefone;

    private String cidade;

    private String plano;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}