package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico,Long>{
    List<Servico> findByStudioId(Long studioId);

}