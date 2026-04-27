package br.com.studio.beautymanager.repository;

import br.com.studio.beautymanager.entity.Studio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository <Studio, Long> {
    List<Studio> findByStudioId(Long studioId);

}
