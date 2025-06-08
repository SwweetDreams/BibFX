package pe.edu.upeu.bibfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.upeu.bibfx.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Page<Libro> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
    Page<Libro> findByAutorContainingIgnoreCase(String autor, Pageable pageable);
    Page<Libro> findByCategoriaContainingIgnoreCase(String categoria, Pageable pageable);
    boolean existsByIsbn(String isbn);
} 