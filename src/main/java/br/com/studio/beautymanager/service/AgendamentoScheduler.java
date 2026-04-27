package br.com.studio.beautymanager.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoScheduler {

    @Scheduled(cron = "0 0 8 * * *")
    public void lembrarAgendamentos(){

        System.out.println("Rodando verificação de lembretes...");

        // aqui vamos buscar agendamentos de amanhã
        // e enviar whatsapp

    }

}