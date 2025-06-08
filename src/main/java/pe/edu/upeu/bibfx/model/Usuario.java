package pe.edu.upeu.bibfx.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El DNI es obligatorio")
    @Column(unique = true)
    private String dni;

    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email es obligatorio")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    private String telefono;
    private String direccion;
    private boolean activo = true;
} 