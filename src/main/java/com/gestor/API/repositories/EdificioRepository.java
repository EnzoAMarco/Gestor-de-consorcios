package com.gestor.API.repositories;

import com.gestor.API.models.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository <Edificio, Integer> {
}
