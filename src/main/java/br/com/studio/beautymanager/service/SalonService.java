package br.com.studio.beautymanager.service;

import br.com.studio.beautymanager.entity.Salon;
import br.com.studio.beautymanager.repository.SalonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    private final SalonRepository repository;

    public SalonService(SalonRepository repository) {
        this.repository = repository;
    }

    public Salon salvar(Salon salon, Long studioId) {
        salon.setStudioId(studioId);
        return repository.save(salon);
    }

    public List<Salon> listar(Long studioId) {
        return repository.findByStudioId(studioId);
    }
}