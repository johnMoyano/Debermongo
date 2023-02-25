package com.example.trabajo.Model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Telefonia")
public class Telefonia {
    private String tipo_telefonia;
    private String telefonia;
}
