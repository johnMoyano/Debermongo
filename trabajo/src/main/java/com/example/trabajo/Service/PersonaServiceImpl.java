package com.example.trabajo.Service;


import com.example.trabajo.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.trabajo.Model.Persona;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    PersonaRepository personaRepository;
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }
}
