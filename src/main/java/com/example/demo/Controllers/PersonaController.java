package com.example.demo.Controllers;

import com.example.demo.Entityes.Persona;
import com.example.demo.Services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaServices personaServices;

    //Create a new
    @PostMapping
    public ResponseEntity<?> create (@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.CREATED).body(personaServices.save(persona));
    }
    //Read an user
    @GetMapping("/{id}")
    public  ResponseEntity<?> read(@PathVariable(value = "id") int userId){
        Optional<Persona> oPersona = personaServices.findById(userId);
        if(!oPersona.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oPersona);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Persona userDetails, @PathVariable(value = "id") int userId){
        Optional<Persona> persona = personaServices.findById(userId);

        if (!persona.isPresent()){
            return ResponseEntity.notFound().build();
        }

        persona.get().setPer_nom(userDetails.getPer_nom());
        persona.get().setPer_apep(userDetails.getPer_apep());

        return ResponseEntity.status(HttpStatus.CREATED).body(personaServices.save(persona.get()));
    }

    //Delete an User
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete (@PathVariable(value = "id") int userId){
        if (!personaServices.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        personaServices.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //Read all Users
    @GetMapping
    public List<Persona> readAll(){
        List<Persona> personas = StreamSupport
                .stream(personaServices.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return personas;
    }
}
