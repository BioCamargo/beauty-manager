package br.com.studio.beautymanager.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    private Boolean sucesso;
    private String mensagem;
    private T dados;
}