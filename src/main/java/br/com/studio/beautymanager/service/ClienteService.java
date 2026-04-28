package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Cliente;
import br.com.studio.beautymanager.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente, Long studioId) {
        cliente.setStudioId(studioId);
        cliente.setDataCadastro(LocalDateTime.now());

        if (cliente.getAtivo() == null) {
            cliente.setAtivo(true);
        }

        return repository.save(cliente);
    }

    public List<Cliente> listar(Long studioId) {
        return repository.findByStudioId(studioId);
    }

    public void excluir(Long id, Long studioId) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if (!cliente.getStudioId().equals(studioId)) {
            throw new RuntimeException("Acesso negado");
        }

        repository.delete(cliente);
    }
}