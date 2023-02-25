package com.example.trabajo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.trabajo.Model.Persona;
import com.example.trabajo.Service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listarProductos() {
        return new ResponseEntity<>(personaService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crearPersona")
    public ResponseEntity<Persona> crearProducto(
            @RequestBody Persona p) {
        return new ResponseEntity<>(personaService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarProducto(@PathVariable Long id, @RequestBody Persona p) {
        Persona personaENcontrada = personaService.findById(id);
        if (personaENcontrada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                personaENcontrada.setNombre(p.getNombre());
                personaENcontrada.setApellido(p.getApellido());
                personaENcontrada.setDireccion(p.getDireccion());
                return new ResponseEntity<>(personaService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminarProducto(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
