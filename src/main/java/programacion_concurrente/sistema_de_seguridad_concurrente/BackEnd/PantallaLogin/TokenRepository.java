package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenInfo, String> {
    TokenInfo findByToken(String token);
}
