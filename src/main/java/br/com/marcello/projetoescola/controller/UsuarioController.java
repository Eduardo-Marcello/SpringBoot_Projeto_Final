package br.com.marcello.projetoescola.controller;

import br.com.marcello.projetoescola.model.Usuario;
import br.com.marcello.projetoescola.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/private")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/usuario/all")
    public ResponseEntity<?> getAll() {
        try{
            return  ResponseEntity.ok(usuarioService.findAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/usuarioId/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        try{
            return  ResponseEntity.ok(usuarioService.findById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/usuarioNome/{nome}")
    public ResponseEntity<?> getByNome(@PathVariable String nome) {
        try{
            return  ResponseEntity.ok(usuarioService.findByNome(nome));
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(usuarioService.save(usuario));
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable String id) {
        try {
            usuarioService.update(id, usuario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Usuário alterado com sucesso!");
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable String id) {
        try {
            usuarioService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Funcionário deleteado com sucesso!");
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }
}
