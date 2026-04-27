package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Agenda;
import br.com.studio.beautymanager.repository.AgendaRepository;
import br.com.studio.beautymanager.service.JwtService;
import br.com.studio.beautymanager.service.WhatsAppService;
import br.com.studio.beautymanager.util.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendaController {

    private final AgendaRepository repository;
    private final WhatsAppService whatsAppService;
    private final JwtService jwtService;
    private final TokenUtil tokenUtil;

    public AgendaController(
            AgendaRepository repository,
            WhatsAppService whatsAppService,
            JwtService jwtService,
            TokenUtil tokenUtil) {

        this.repository = repository;
        this.whatsAppService = whatsAppService;
        this.jwtService = jwtService;
        this.tokenUtil = tokenUtil;
    }

   @PostMapping
        public Agenda salvar(
                @RequestBody Agenda agendamento,
                HttpServletRequest request) {

        String token = tokenUtil.extrairToken(request);

        Long studioId = jwtService.getStudioId(token);

        agendamento.setStudioId(studioId);

        Agenda salvo = repository.save(agendamento);

        String msg = "Seu horário foi agendado para "
                + agendamento.getDataHora();

        whatsAppService.enviarMensagem("5519999999999", msg);

        return salvo;
        }
}