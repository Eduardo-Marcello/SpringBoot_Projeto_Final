package br.com.marcello.projetoescola.controller;

import br.com.marcello.projetoescola.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public")
public class PublicUsuarioController {
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
}
