package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Agenda;
import br.com.studio.beautymanager.entity.AgendaServico;
import br.com.studio.beautymanager.entity.Servico;
import br.com.studio.beautymanager.repository.AgendaRepository;
import br.com.studio.beautymanager.repository.ServicoRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final ServicoRepository servicoRepository;

    public AgendaService(AgendaRepository agendaRepository,
                         ServicoRepository servicoRepository) {
        this.agendaRepository = agendaRepository;
        this.servicoRepository = servicoRepository;
    }

    public Agenda criarAgendamento(Agenda agenda, Long studioId) {
        LocalDateTime inicio = agenda.getDataHora();
        int duracaoTotal = 0;

        // 1️⃣ calcular duração total
        for (AgendaServico item : agenda.getServicos()) {
            Servico servico = servicoRepository.findById(agenda.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

            item.setDuracaoMinutos(servico.getDuracao());

            duracaoTotal += servico.getDuracao();
        }
        // 2️⃣ calcular fim automático
        LocalDateTime fim = inicio.plusMinutes(duracaoTotal);

        agenda.setDataHoraFim(fim);
        agenda.setStudioId(studioId);

        // 3️⃣ validar conflito (PACOTE COMPLETO)
        List<Agenda> conflitos = agendaRepository.buscarConflitos(
                studioId, inicio, fim
        );

        if (!conflitos.isEmpty()) {
            throw new RuntimeException("Horário já ocupado para esse período");
        }

        // 4️⃣ salvar agenda
        Agenda salva = agendaRepository.save(agenda);

        // 5️⃣ vincular serviços
        int ordem = 1;
        for (AgendaServico item : agenda.getServicos()) {
            item.setAgenda(salva);
            item.setOrdem(ordem++);
        }

    return agendaRepository.save(salva);
    }
}