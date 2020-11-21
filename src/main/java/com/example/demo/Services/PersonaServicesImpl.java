package com.example.demo.Services;

import com.example.demo.Entityes.Persona;
import com.example.demo.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class PersonaServicesImpl implements PersonaServices{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(Pageable pageable) {
        return personaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> findById(int id) {
        return personaRepository.findById(id) ;
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        personaRepository.deleteById(id);
    }
}
