package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final UsuarioService usuarioService;

    public RegistroController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario, @RequestParam String rol) {
        String respuesta = usuarioService.registrarUsuario(usuario, rol);
        if (respuesta.equals("Usuario registrado con éxito")) {
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.status(400).body(respuesta);
        }
    }
}

