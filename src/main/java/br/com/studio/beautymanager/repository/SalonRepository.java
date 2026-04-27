package br.com.studio.beautymanager.repository;
import br.com.studio.beautymanager.entity.Salon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, Long> {

    List<Salon> findByStudioId(Long studioId);

}