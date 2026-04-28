package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.dto.ClienteDTO;
import br.com.studio.beautymanager.entity.Cliente;
import br.com.studio.beautymanager.mapper.ClienteMapper;
import br.com.studio.beautymanager.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteDTO salvar(@RequestBody ClienteDTO dto) {
        Cliente cliente = ClienteMapper.toEntity(dto);
        Cliente salvo = service.salvar(cliente, getStudioId());
        return ClienteMapper.toDTO(salvo);
    }

    @GetMapping
    public List<ClienteDTO> listar() {
        return service.listar(getStudioId())
                .stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id, getStudioId());
    }
}