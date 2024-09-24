package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaMonitoreoSensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaMonitoreoSensores.SensorMonitorDTO;
import programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaMonitoreoSensores.SensorMonitorService;

import java.util.List;

@RestController
@RequestMapping("/api/sensorMonitor")
public class SensorMonitorResource {

    private final SensorMonitorService sensorMonitorService;

    @Autowired
    public SensorMonitorResource(SensorMonitorService sensorMonitorService) {
        this.sensorMonitorService = sensorMonitorService;
    }

    @GetMapping
    public ResponseEntity<List<SensorMonitorDTO>> getSensorMonitorData() {
        List<SensorMonitorDTO> sensorMonitorData = sensorMonitorService.getSensorMonitorData();
        return ResponseEntity.ok(sensorMonitorData);
    }
}
