package programacion_concurrente.sistema_de_seguridad_concurrente.domain;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Eventos")
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(nullable = false)
    private String nivelCriticidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventos_id")
    private SensorAcceso eventos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoss_id")
    private SensorMovimiento eventoss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventosss_id")
    private SensorTemperatura eventosss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_temperatura_id")
    private SensorTemperatura sensorTemperatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_movimiento_id")
    private SensorMovimiento sensorMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_acceso_id")
    private SensorAcceso sensorAcceso;

    @Column(nullable = false)
    private OffsetDateTime fechaHora;

    @Column(nullable = false)
    private String tipoEvento;

    @Column(nullable = false)
    private String descripcion;

}
