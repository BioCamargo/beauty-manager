package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Servico;
import br.com.studio.beautymanager.repository.ServicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository repository;

    public ServicoService(ServicoRepository repository) {
        this.repository = repository;
    }

    public Servico salvar(Servico servico, Long studioId) {
        servico.setStudioId(studioId);
        servico.setDataCadastro(LocalDateTime.now());
        return repository.save(servico);
    }

    public List<Servico> listar(Long studioId) {
        return repository.findByStudioId(studioId);
    }

    public Servico atualizar(Long id, Servico novo) {
        Servico servico = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servico.setNome(novo.getNome());
        servico.setDescricao(novo.getDescricao());
        servico.setPreco(novo.getPreco());
        servico.setDuracao(novo.getDuracao());

        return repository.save(servico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}