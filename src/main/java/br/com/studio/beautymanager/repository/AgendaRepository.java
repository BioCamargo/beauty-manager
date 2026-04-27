package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByStudioId(Long studioId);
}