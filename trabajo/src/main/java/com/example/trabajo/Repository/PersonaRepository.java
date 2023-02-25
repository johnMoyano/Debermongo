package com.example.trabajo.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.trabajo.Model.Persona;

public interface PersonaRepository extends MongoRepository<Persona,Long> {
}
