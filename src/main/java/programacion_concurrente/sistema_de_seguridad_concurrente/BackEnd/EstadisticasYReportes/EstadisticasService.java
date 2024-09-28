package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.EstadisticasYReportes;
import org.springframework.stereotype.Service;

@Service
public class EstadisticasService {

    private EstadisticasDTO estadisticas;

    public EstadisticasService() {
        // Inicializa con valores predeterminados
        this.estadisticas = new EstadisticasDTO(12, 4, 2, "Activo desde 10:00 AM", "Advertencia a las 10:32 AM");
    }

    public EstadisticasDTO getEstadisticas() {
        return estadisticas;
    }

    public void updateEstadisticas(EstadisticasDTO newEstadisticas) {
        this.estadisticas = newEstadisticas;
    }
}

