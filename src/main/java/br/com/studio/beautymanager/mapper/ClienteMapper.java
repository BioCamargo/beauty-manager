package br.com.studio.beautymanager.mapper;

import br.com.studio.beautymanager.dto.ClienteDTO;
import br.com.studio.beautymanager.entity.Cliente;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente c) {
        return ClienteDTO.builder()
                .id(c.getId())
                .nome(c.getNome())
                .telefone(c.getTelefone())
                .email(c.getEmail())
                .observacao(c.getObservacao())
                .ativo(c.getAtivo())
                .build();
    }

    public static Cliente toEntity(ClienteDTO dto) {
        return Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .email(dto.getEmail())
                .observacao(dto.getObservacao())
                .ativo(dto.getAtivo())
                .build();
    }
}