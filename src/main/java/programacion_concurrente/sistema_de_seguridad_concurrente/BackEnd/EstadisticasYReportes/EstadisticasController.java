package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.EstadisticasYReportes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasService estadisticasService;

    // Obtener estadísticas actuales
    @GetMapping
    public EstadisticasDTO getEstadisticas() {
        return estadisticasService.getEstadisticas();
    }

    // Actualizar estadísticas
    @PutMapping
    public void updateEstadisticas(@RequestBody EstadisticasDTO newEstadisticas) {
        estadisticasService.updateEstadisticas(newEstadisticas);
    }
}
