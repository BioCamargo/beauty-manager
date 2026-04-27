package br.com.studio.beautymanager.controller;

import br.com.studio.beautymanager.entity.Salon;
import br.com.studio.beautymanager.service.SalonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salons")
public class SalonController {

    private final SalonService service;

    public SalonController(SalonService service) {
        this.service = service;
    }

    @PostMapping
    public Salon criar(@RequestBody Salon salon) {
        return service.criar(salon);
    }

}