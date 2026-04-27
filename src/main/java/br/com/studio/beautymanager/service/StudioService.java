package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Studio;
import br.com.studio.beautymanager.repository.StudioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    private final StudioRepository repository;

    public StudioService(StudioRepository repository) {
        this.repository = repository;
    }

    public List<Studio> listar() {
        return repository.findAll();
    }
}
