package br.com.marcello.projetoescola.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String senha;
    private String papel;
}
