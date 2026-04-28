package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByStudioId(Long studioId);
}