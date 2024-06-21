package br.com.marcello.projetoescola;

import br.com.marcello.projetoescola.model.Departamento;
import br.com.marcello.projetoescola.model.Funcionario;
import br.com.marcello.projetoescola.repository.DepartamentoRepository;
import br.com.marcello.projetoescola.repository.FuncionarioRepository;
import br.com.marcello.projetoescola.service.FuncionarioService;
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
public class FuncionarioServiceTest {
    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    @DisplayName("Deve criar um funcionario no banco")
    public void addFuncionarioTest() {
        Funcionario funcionario = new Funcionario();
        Departamento departamento = new Departamento();
        departamento.setNome("TI");
        departamento.setLocal("ALa Oeste");
        departamentoRepository.save(departamento);
        funcionario.setNome("Marcello");
        funcionario.setDepartamento(departamento);
        funcionario.setTelefone("123456789");
        funcionario.setEmail("marcello@gmail.com");
        funcionario.setEndereco("maria 18");
        funcionarioRepository.save(funcionario);
        List<Funcionario> all = funcionarioRepository.findAll();
        assertEquals(1, all.size());
    }

    @Test
    @DisplayName("Deve retornar um funcionario pelo id")
    public void deveRetornarUmFuncionarioPeloId() {
        Funcionario funcionario = new Funcionario();
        Departamento departamento = new Departamento();
        departamento.setNome("TI");
        departamento.setLocal("ALa Oeste");
        departamentoRepository.save(departamento);
        funcionario.setNome("Marcello");
        funcionario.setDepartamento(departamento);
        funcionario.setTelefone("123456789");
        funcionario.setEmail("marcello@gmail.com");
        funcionario.setEndereco("maria 18");
        funcionarioRepository.save(funcionario);
        Optional<Funcionario> byId = funcionarioRepository.findById(1l);
        assertTrue(byId.isPresent());
    }
}
