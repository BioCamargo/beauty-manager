package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Agenda;
import br.com.studio.beautymanager.service.AgendaService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agenda")
public class AgendaController extends BaseController {

    private final AgendaService service;

    public AgendaController(AgendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Agenda agenda,
                                Authentication auth) {

        Long studioId = (Long) auth.getPrincipal();

        try {
            Agenda novo = service.criarAgendamento(agenda, studioId);
            return ResponseEntity.ok(novo);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

   /*  @GetMapping
    public List<Agenda> listar() {
        return service.listar(getStudioId());
    }*/

    
}