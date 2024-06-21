package br.com.marcello.projetoescola.service;

import br.com.marcello.projetoescola.model.Usuario;
import br.com.marcello.projetoescola.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        if(usuarioRepository.findAll().isEmpty()){
            throw new RuntimeException("Erro ao listar os usuario! Não há usuário cadastrados!");
        } else {
            return usuarioRepository.findAll();
        }
    }

    public Optional<Usuario> findById(String id){
        if (usuarioRepository.existsById(id)){
            return usuarioRepository.findById(id);
        } else {
            throw new RuntimeException("Erro ao idetificar o usuario! Id inextistente!");
        }
    }

    public Usuario save(Usuario usuario){
        if(usuario.getPapel().isEmpty() | usuario.getPapel().isEmpty()){
            throw new RuntimeException("Erro ao inserir usuario! Existem campos não preenchidos!");
        } else {
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }
    }

    public void delete(String id){
        if(usuarioRepository.existsById(id)){
           usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuário não encontrado! Id inexistente");
        }
    }

    public Usuario update(String id, Usuario usuarioUpdate){
        usuarioRepository.findById(id).map(usuario -> {
            usuario.setSenha(usuarioUpdate.getSenha());
            usuario.setPapel(usuarioUpdate.getPapel());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado! Id inexistente"));
        return usuarioUpdate;
    }

    public Usuario findByNome(String nome){
        return usuarioRepository.findbyNome(nome);
    }
}

