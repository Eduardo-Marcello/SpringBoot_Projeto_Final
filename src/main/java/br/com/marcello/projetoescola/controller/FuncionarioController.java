package br.com.marcello.projetoescola.controller;

import br.com.marcello.projetoescola.model.Funcionario;
import br.com.marcello.projetoescola.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public")
public class FuncionarioController {
    final FuncionarioService funcionarioService;

    @GetMapping("/funcionario/all")
    public ResponseEntity<?> getAllFuncionarios() {
        try{
            return  ResponseEntity.ok(funcionarioService.findAll());
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<?> getFuncionarioById(@PathVariable Long id) {
        try{
            return  ResponseEntity.ok(funcionarioService.findById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PostMapping("/funcionario/save")
    public ResponseEntity<?> saveFuncionario(@RequestBody Funcionario funcionario) {
        try {
            return ResponseEntity.ok(funcionarioService.save(funcionario));
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @PostMapping("/funcionario/departamento/{departamentoId}")
    public Funcionario addDepartamentoFuncionario(@PathVariable Long departamentoId, @RequestBody Funcionario funcionario){
        return funcionarioService.addDepartamentoFuncionario(departamentoId, funcionario);

    }

    @PutMapping("/funcionario/update/{id}")
    public ResponseEntity<?> updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable Long id) {
        try {
            funcionarioService.update(id, funcionario);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Funcionário alterado com sucesso!");
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @DeleteMapping("/funcionario/delete/{id}")
    public ResponseEntity<?> deleteFuncionario(@PathVariable Long id) {
        try {
            funcionarioService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Funcionário deleteado com sucesso!");
        } catch (RuntimeException ex) {
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    }
