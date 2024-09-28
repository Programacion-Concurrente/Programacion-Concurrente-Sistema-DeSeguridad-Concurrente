package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
public class TokenInfo {
    @Id
    private String token;
    private String username;
    private Date expiration;
}
