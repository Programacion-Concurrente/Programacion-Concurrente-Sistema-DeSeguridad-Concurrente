package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtil {

    @Autowired
    private TokenRepository tokenRepository;

    public String generarToken(String username) {
        String token = UUID.randomUUID().toString();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setToken(token);
        tokenInfo.setUsername(username);
        tokenInfo.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)); // 10 horas
        tokenRepository.save(tokenInfo);
        return token;
    }

    public boolean validarToken(String token, String username) {
        TokenInfo tokenInfo = tokenRepository.findByToken(token);
        return tokenInfo != null && tokenInfo.getUsername().equals(username) && !isTokenExpirado(tokenInfo);
    }

    public String extraerUsername(String token) {
        TokenInfo tokenInfo = tokenRepository.findByToken(token);
        return tokenInfo != null ? tokenInfo.getUsername() : null;
    }

    private boolean isTokenExpirado(TokenInfo tokenInfo) {
        return tokenInfo.getExpiration().before(new Date());
    }
}
