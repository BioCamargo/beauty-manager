package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.dto.ApiResponse;
import br.com.studio.beautymanager.entity.Cliente;
import br.com.studio.beautymanager.service.ClienteService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<Cliente> salvar(@RequestBody Cliente cliente) {

        Cliente salvo = service.salvar(cliente, getStudioId());

        return ApiResponse.<Cliente>builder()
                .sucesso(true)
                .dados(salvo)
                .build();
    }

    @GetMapping
    public String listar() {
        Long studioId = getStudioId();

        return "Studio logado: " + studioId;
    }

    
}