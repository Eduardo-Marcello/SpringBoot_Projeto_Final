package br.com.marcello.projetoescola;

import br.com.marcello.projetoescola.model.Departamento;
import br.com.marcello.projetoescola.repository.DepartamentoRepository;
import br.com.marcello.projetoescola.service.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class DepartamentoServiceTest {
    @Autowired
    DepartamentoService departamentoService;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    @DisplayName("Deve retornar um departamento")
    public void deveRetornarUmDepartamento() {
        Departamento departamento = new Departamento();
        departamento.setNome("TI");
        departamento.setLocal("ALa Oeste");
        departamentoRepository.save(departamento);
        List<Departamento> all = departamentoRepository.findAll();
        assertEquals(2, all.size());
    }

    @Test
    @DisplayName("Deve retornar um departamento pelo Id")
    public void deveRetornarUmDepartamentoPeloId() {
        Departamento departamento = new Departamento();
        departamento.setNome("TI");
        departamento.setLocal("ALa Oeste");
        departamentoRepository.save(departamento);
        Optional<Departamento> byId = departamentoRepository.findById(1L);
        assertTrue(byId.isPresent());
    }

}
