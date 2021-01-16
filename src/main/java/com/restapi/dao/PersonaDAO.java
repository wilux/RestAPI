package com.restapi.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer> {

}
