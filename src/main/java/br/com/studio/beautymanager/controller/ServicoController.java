package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Servico;
import br.com.studio.beautymanager.repository.ServicoRepository;
import br.com.studio.beautymanager.service.JwtService;
import br.com.studio.beautymanager.util.TokenUtil;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoRepository repository;
    private final JwtService jwtService;
    private final TokenUtil tokenUtil;

    public ServicoController(
            ServicoRepository repository,
            JwtService jwtService,
            TokenUtil tokenUtil) {

        this.repository = repository;
        this.jwtService = jwtService;
        this.tokenUtil = tokenUtil;
    }

    @PostMapping
    public Servico salvar(
            @RequestBody Servico servico,
            HttpServletRequest request){

        String token = tokenUtil.extrairToken(request);

        Long studioId = jwtService.getStudioId(token);

        servico.setStudioId(studioId);

        return repository.save(servico);
    }

    @GetMapping
    public List<Servico> listar(HttpServletRequest request){

        String token = tokenUtil.extrairToken(request);

        Long studioId = jwtService.getStudioId(token);

        return repository.findByStudioId(studioId);
    }

}