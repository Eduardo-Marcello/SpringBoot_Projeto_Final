package br.com.marcello.projetoescola.controller;

import br.com.marcello.projetoescola.model.Departamento;
import br.com.marcello.projetoescola.repository.FuncionarioRepository;
import br.com.marcello.projetoescola.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class DepartamentoController {
    final DepartamentoService departamentoService;
    final FuncionarioRepository funcionarioRepository;

    @GetMapping("/departamento/all")
    public ResponseEntity<?> getAllDepartamento() {
        try{
            return  ResponseEntity.ok(departamentoService.findAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity<?> getDepartamentoById(@PathVariable Long id) {
        try{
            return  ResponseEntity.ok(departamentoService.findById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }


    @PostMapping("/departamento/save")
    public ResponseEntity<?> saveDepartamento(@RequestBody Departamento departamento) {
        try {
            return ResponseEntity.ok(departamentoService.save(departamento));
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PutMapping("/departamento/update/{id}")
    public ResponseEntity<?> updateDepartamento(@RequestBody Departamento departamento, @PathVariable Long id) {
        try {
            departamentoService.update(id, departamento);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Departamento alterado com sucesso!");
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @DeleteMapping("/departamento/delete/{id}")
    public ResponseEntity<?> deleteDepartamento(@PathVariable Long id) {
        try {
            departamentoService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Departamento deleteado com sucesso!");
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

}
