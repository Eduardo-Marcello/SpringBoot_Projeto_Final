package br.com.marcello.projetoescola.repository;

import br.com.marcello.projetoescola.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    @Query("{nome: ?0}")
    Usuario findbyNome(String nome);
}
