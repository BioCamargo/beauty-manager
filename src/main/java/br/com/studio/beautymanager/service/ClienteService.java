package br.com.studio.beautymanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.studio.beautymanager.entity.Cliente;
import br.com.studio.beautymanager.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente, Long studioId) {
        cliente.setStudioId(studioId);
        return repository.save(cliente);
    }

    public List<Cliente> listar(Long studioId) {
        return repository.findByStudioId(studioId);
    }
}