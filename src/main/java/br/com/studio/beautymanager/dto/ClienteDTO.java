package br.com.studio.beautymanager.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String observacao;
    private Boolean ativo;
}