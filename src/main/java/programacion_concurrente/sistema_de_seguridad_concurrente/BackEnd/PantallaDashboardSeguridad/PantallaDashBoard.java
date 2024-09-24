package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaDashboardSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PantallaDashBoard {

    private final DashboardService dashboardService;

    @Autowired
    public PantallaDashBoard(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    public List<DashboardDTO> obtenerDatosDashboard() {
        return dashboardService.getDashboardData();
    }
}
