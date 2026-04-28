package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByStudioId(Long studioId);


    @Query("""
        SELECT a FROM Agenda a
        WHERE a.studioId = :studioId
        AND a.dataHora < :fim
        AND a.dataHoraFim > :inicio
    """)
    List<Agenda> buscarConflitos(
        Long studioId,
        LocalDateTime inicio,
        LocalDateTime fim
    );
}

