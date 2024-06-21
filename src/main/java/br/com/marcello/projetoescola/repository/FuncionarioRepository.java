package br.com.marcello.projetoescola.repository;

import br.com.marcello.projetoescola.model.Departamento;
import br.com.marcello.projetoescola.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByDepartamentoId(Long departamentoId);
}
