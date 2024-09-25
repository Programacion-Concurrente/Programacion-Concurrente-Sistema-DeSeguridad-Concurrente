package programacion_concurrente.sistema_de_seguridad_concurrente.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorAcceso;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorMovimiento;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorTemperatura;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorAccesoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorMovimientoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorTemperaturaRepository;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;


@Service
public class SensorMonitorService {

    private final SensorMovimientoRepository sensorMovimientoRepository;
    private final SensorTemperaturaRepository sensorTemperaturaRepository;
    private final SensorAccesoRepository sensorAccesoRepository;

    public SensorMonitorService(SensorMovimientoRepository sensorMovimientoRepository,
                                SensorTemperaturaRepository sensorTemperaturaRepository,
                                SensorAccesoRepository sensorAccesoRepository) {
        this.sensorMovimientoRepository = sensorMovimientoRepository;
        this.sensorTemperaturaRepository = sensorTemperaturaRepository;
        this.sensorAccesoRepository = sensorAccesoRepository;
    }

    @Async("taskExecutor")
    public CompletableFuture<Void> generateRandomEvents() {
        List<SensorMovimiento> sensorMovimientos = sensorMovimientoRepository.findAll();
        List<SensorTemperatura> sensorTemperaturas = sensorTemperaturaRepository.findAll();
        List<SensorAcceso> sensorAccesos = sensorAccesoRepository.findAll();
        Random random = new Random();

        sensorMovimientos.forEach(sensor -> {
            int randomEventCount = random.nextInt(10) + 1;
            for (int i = 0; i < randomEventCount; i++) {
                System.out.println("Sensor Movimiento: " + sensor.getNombre() + " - Evento: " + i);
            }
        });

        sensorTemperaturas.forEach(sensor -> {
            int randomEventCount = random.nextInt(10) + 1;
            for (int i = 0; i < randomEventCount; i++) {
                System.out.println("Sensor Temperatura: " + sensor.getNombre() + " - Evento: " + i);
            }
        });

        sensorAccesos.forEach(sensor -> {
            int randomEventCount = random.nextInt(10) + 1;
            for (int i = 0; i < randomEventCount; i++) {
                System.out.println("Sensor Acceso: " + sensor.getNombre() + " - Evento: " + i);
            }
        });

        return CompletableFuture.completedFuture(null);
    }
}
