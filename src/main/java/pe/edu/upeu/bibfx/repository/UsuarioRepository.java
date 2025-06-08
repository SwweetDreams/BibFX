package pe.edu.upeu.bibfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.bibfx.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByDni(String dni);
    boolean existsByEmail(String email);
    boolean existsByDni(String dni);
} 