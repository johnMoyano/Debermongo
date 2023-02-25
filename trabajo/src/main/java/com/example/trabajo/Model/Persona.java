package com.example.trabajo.Model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Persona")
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private String direccion;

    //Relaciones uno a uno
    private Contactos contactos;

    //Relaciones uno a muchos
    private List<Contactos> list_contactos;
}
