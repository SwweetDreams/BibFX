package pe.edu.upeu.bibfx.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.upeu.bibfx.model.Libro;

public interface LibroService {
    Libro save(Libro libro);
    Libro update(Long id, Libro libro);
    void delete(Long id);
    Libro findById(Long id);
    Page<Libro> findAll(Pageable pageable);
    Page<Libro> findByTitulo(String titulo, Pageable pageable);
    Page<Libro> findByAutor(String autor, Pageable pageable);
    Page<Libro> findByCategoria(String categoria, Pageable pageable);
    boolean existsByIsbn(String isbn);
} 