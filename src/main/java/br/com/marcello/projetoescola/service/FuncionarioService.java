package br.com.marcello.projetoescola.service;

import br.com.marcello.projetoescola.model.Funcionario;
import br.com.marcello.projetoescola.repository.DepartamentoRepository;
import br.com.marcello.projetoescola.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    final FuncionarioRepository funcionarioRepository;
    final DepartamentoRepository departamentoRepository;

    public List<Funcionario> findAll(){
        if(funcionarioRepository.findAll().isEmpty()){
            throw new RuntimeException("Erro ao listar os funcionários! Não há funcionários cadastrados!");
        } else {
            return funcionarioRepository.findAll();
        }
    }

    public Optional<Funcionario> findById(Long id){
        if (funcionarioRepository.existsById(id)){
            return funcionarioRepository.findById(id);
        } else {
            throw new RuntimeException("Erro ao idetificar o funcionario! Id inextistente!");
        }

    }

    public Funcionario addDepartamentoFuncionario(Long departamentoId, Funcionario funcionario) {
        return departamentoRepository.findById(departamentoId).map(departamento -> {
            funcionario.setDepartamento(departamento);
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(()-> new RuntimeException("Departamento não encontrado com id: " +departamentoId));
    }

    public Funcionario save(Funcionario funcionario){
        if(funcionario.getNome().isEmpty()
                || funcionario.getEndereco().isEmpty()
                || funcionario.getTelefone().isEmpty()
                || funcionario.getEmail().isEmpty()
                || funcionario.getDataNascimento() == null){
            throw new RuntimeException("Erro ao inserir funcionario! Existem campos não preenchidos!");
        } else {
            return funcionarioRepository.save(funcionario);
        }
    }

    public void delete(Long id){
        if(funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funionário não encontrado! Id inexistente");
        }

    }

    public void update(Long id, Funcionario funcionarioUpdate){
        funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioUpdate.getNome());
            funcionario.setEndereco(funcionarioUpdate.getEndereco());
            funcionario.setTelefone(funcionarioUpdate.getTelefone());
            funcionario.setEmail(funcionarioUpdate.getEmail());
            funcionario.setDataNascimento(funcionarioUpdate.getDataNascimento());
            return funcionarioRepository.save(funcionario);
        }).orElseThrow(() -> new RuntimeException("Funionário não encontrado! Id inexistente"));
    }
}
