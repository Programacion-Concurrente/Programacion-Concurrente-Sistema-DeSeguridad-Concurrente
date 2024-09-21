package programacion_concurrente.sistema_de_seguridad_concurrente.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.Evento;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorAcceso;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorMovimiento;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorTemperatura;


public interface EventoRepository extends JpaRepository<Evento, Integer> {

    Evento findFirstByEventos(SensorTemperatura sensorTemperatura);

    Evento findFirstByEventoss(SensorMovimiento sensorMovimiento);

    Evento findFirstByEventosss(SensorAcceso sensorAcceso);

}
