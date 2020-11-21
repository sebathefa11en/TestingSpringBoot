package com.example.demo.Services;

import com.example.demo.Entityes.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PersonaServices {
    public Iterable<Persona> findAll();

    public Page<Persona> findAll(Pageable pageable);

    public Optional<Persona> findById(int id);

    public Persona save(Persona persona);

    public void deleteById(int id);
}
