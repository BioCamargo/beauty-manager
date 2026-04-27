package br.com.studio.beautymanager.controller;
import br.com.studio.beautymanager.entity.Studio;
import br.com.studio.beautymanager.service.StudioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studio")
public class StudioController {

    private final StudioService service;

    public StudioController(StudioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Studio> listar() {
        return service.listar();
    }
}
