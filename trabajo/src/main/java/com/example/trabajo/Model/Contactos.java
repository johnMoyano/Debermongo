package com.example.trabajo.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Contactos")
public class Contactos {
    private String correo;
    private String celular;
    private Telefonia telefonia;

    //relaciones


}
