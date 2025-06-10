package pe.edu.upeu.bibfx.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.upeu.bibfx.modelo.Usuario;
import pe.edu.upeu.bibfx.repositorio.UsuarioRepository;

@Component
public class DataInitializer {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        // Crear usuario administrador por defecto si no existe
        if (!usuarioRepository.existsByEmail("admin@biblioteca.com")) {
            Usuario admin = new Usuario();
            admin.setDni("12345678");
            admin.setNombres("Administrador");
            admin.setApellidos("Sistema");
            admin.setEmail("admin@biblioteca.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setTipoUsuario(Usuario.TipoUsuario.ADMINISTRADOR);
            admin.setEstado(Usuario.EstadoUsuario.ACTIVO);
            
            usuarioRepository.save(admin);
        }
    }
} 