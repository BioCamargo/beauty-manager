package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Salon;
import br.com.studio.beautymanager.service.SalonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salons")
public class SalonController extends BaseController {

    private final SalonService service;

    public SalonController(SalonService service) {
        this.service = service;
    }

    @PostMapping
    public Salon salvar(@RequestBody Salon salon) {
        return service.salvar(salon, getStudioId());
    }

    @GetMapping
    public List<Salon> listar() {
        return service.listar(getStudioId());
    }
}