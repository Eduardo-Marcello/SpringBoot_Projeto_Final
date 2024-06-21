package br.com.marcello.projetoescola.service;

import br.com.marcello.projetoescola.model.Departamento;
import br.com.marcello.projetoescola.repository.DepartamentoRepository;
import br.com.marcello.projetoescola.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public List<Departamento> findAll() {
        if(departamentoRepository.findAll().isEmpty()){
            throw new RuntimeException("Erro ao listar os departamentos! Não há departamentos cadastrados!");
        } else {
            return departamentoRepository.findAll();
        }
    }

    public Optional<Departamento> findById(Long id) {
        if (departamentoRepository.existsById(id)){
            return departamentoRepository.findById(id);
        } else {
            throw new RuntimeException("Erro ao idetificar o departamento! Id inextistente!");
        }
    }


    public Departamento save(Departamento departamento) {
        if(departamento.getNome().isEmpty() || departamento.getLocal().isEmpty()){
            throw new RuntimeException("Erro ao inserir departamento! Existem campos não preenchidos!");
        } else {
            return departamentoRepository.save(departamento);
        }
    }

    public void delete(Long id) {
        if(departamentoRepository.existsById(id)){
            departamentoRepository.deleteById(id);
        } else {
             throw new RuntimeException("Departamento não encontrado! Id inexistente");
        }
    }

    public void update(Long id, Departamento departamentoUpdate) {
        departamentoRepository.findById(id).map(departamento -> {
            departamento.setNome(departamentoUpdate.getNome());
            departamento.setLocal(departamentoUpdate.getLocal());
            return departamentoRepository.save(departamento);
        }).orElseThrow(() -> new RuntimeException("Departamento não encontrado! Id inexistente"));
    }
}
