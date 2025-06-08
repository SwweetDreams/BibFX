package pe.edu.upeu.bibfx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.edu.upeu.bibfx.model.Prestamo;
import java.time.LocalDateTime;
import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    Page<Prestamo> findByUsuarioId(Long usuarioId, Pageable pageable);
    Page<Prestamo> findByLibroId(Long libroId, Pageable pageable);
    List<Prestamo> findByEstadoAndFechaDevolucionBefore(String estado, LocalDateTime fecha);
    boolean existsByLibroIdAndUsuarioIdAndEstado(Long libroId, Long usuarioId, String estado);
} 