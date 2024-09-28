package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registrarUsuario(Usuario usuario, String rol) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioExistente.isPresent()) {
            return "El nombre de usuario ya está en uso";
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Encriptar la contraseña
        usuario.setRoles(Collections.singletonList(rol)); // Asignar rol

        usuarioRepository.save(usuario);
        return "Usuario registrado con éxito";
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public boolean eliminarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
