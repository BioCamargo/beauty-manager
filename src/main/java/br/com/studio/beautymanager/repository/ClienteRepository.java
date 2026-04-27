package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByStudioId(Long studioId);
}