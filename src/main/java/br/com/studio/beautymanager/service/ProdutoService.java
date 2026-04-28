package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Produto;
import br.com.studio.beautymanager.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvar(Produto produto, Long studioId) {
        produto.setStudioId(studioId);
        produto.setDataCadastro(LocalDateTime.now());
        return repository.save(produto);
    }

    public List<Produto> listar(Long studioId) {
        return repository.findByStudioId(studioId);
    }

    public Produto atualizar(Long id, Produto novo) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(novo.getNome());
        produto.setDescricao(novo.getDescricao());
        produto.setPreco(novo.getPreco());
        produto.setEstoque(novo.getEstoque());

        return repository.save(produto);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}