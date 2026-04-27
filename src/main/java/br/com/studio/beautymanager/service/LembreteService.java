package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.repository.AgendaRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LembreteService {

    private final AgendaRepository repository;
    private final WhatsAppService whatsAppService;

    public LembreteService(
            AgendaRepository repository,
            WhatsAppService whatsAppService){

        this.repository = repository;
        this.whatsAppService = whatsAppService;
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void enviarLembretes(){

        LocalDate amanha = LocalDate.now().plusDays(1);

       /*  List<Agenda> lista = repository.buscarPorData(amanha);

        for(Agenda a : lista){

            String msg = "Olá! Lembrando do seu horário amanhã às "
                    + a.getHora();

            whatsAppService.enviarMensagem(
                    "5519999999999",
                    msg
            );

        }*/

    }

}