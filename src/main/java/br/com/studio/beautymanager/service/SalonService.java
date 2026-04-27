package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Salon;
import br.com.studio.beautymanager.repository.SalonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalonService {

    private final SalonRepository repository;

    public SalonService(SalonRepository repository) {
        this.repository = repository;
    }

    public Salon criar(Salon salon) {
        salon.setDataCadastro(LocalDateTime.now());
        return repository.save(salon);
    }
}