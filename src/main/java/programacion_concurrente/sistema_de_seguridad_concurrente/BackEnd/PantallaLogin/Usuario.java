package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    private String username;

    @NotEmpty(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotEmpty(message = "Los apellidos no pueden estar vacíos")
    private String apellidos;

    @NotEmpty(message = "El email no puede estar vacío")
    @Email(message = "Email no válido")
    private String email;

    @NotEmpty(message = "El teléfono no puede estar vacío")
    private String telefono;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles; // Almacena los roles del usuario (ADMIN, USER)
}
