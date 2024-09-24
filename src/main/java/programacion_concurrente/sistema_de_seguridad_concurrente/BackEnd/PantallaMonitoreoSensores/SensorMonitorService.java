package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaMonitoreoSensores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.PantallaMonitoreoSensores.SensorMonitorDTO;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorMovimientoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorTemperaturaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorMonitorService {

    private final SensorMovimientoRepository sensorMovimientoRepository;
    private final SensorTemperaturaRepository sensorTemperaturaRepository;

    @Autowired
    public SensorMonitorService(SensorMovimientoRepository sensorMovimientoRepository,
                                SensorTemperaturaRepository sensorTemperaturaRepository) {
        this.sensorMovimientoRepository = sensorMovimientoRepository;
        this.sensorTemperaturaRepository = sensorTemperaturaRepository;
    }

    public List<SensorMonitorDTO> getSensorMonitorData() {
        List<SensorMonitorDTO> movimientoData = sensorMovimientoRepository.findAll().stream()
            .map(sensor -> {
                SensorMonitorDTO dto = new SensorMonitorDTO();
                dto.setIdSensor(sensor.getIdSensor());
                dto.setSensorType("Movimiento");
                dto.setStatus("Activo"); // Assuming status is always "Activo"
                dto.setLastReadingTime(sensor.getLastModifiedDate());
                dto.setLastReadingValue("Movimiento detectado");
                dto.setLastDetectionTime(sensor.getLastModifiedDate());
                return dto;
            }).collect(Collectors.toList());

        List<SensorMonitorDTO> temperaturaData = sensorTemperaturaRepository.findAll().stream()
            .map(sensor -> {
                SensorMonitorDTO dto = new SensorMonitorDTO();
                dto.setIdSensor(sensor.getIdSensor());
                dto.setSensorType("Temperatura");
                dto.setStatus(sensor.getTemperatura() + "°C");
                dto.setLastReadingTime(sensor.getLastUpdated());
                dto.setLastReadingValue(sensor.getTemperatura() + "°C");
                dto.setLastDetectionTime(sensor.getLastUpdated());
                return dto;
            }).collect(Collectors.toList());

        movimientoData.addAll(temperaturaData);
        return movimientoData;
    }
}
