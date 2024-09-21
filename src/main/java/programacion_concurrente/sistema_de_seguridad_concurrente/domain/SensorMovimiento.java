package programacion_concurrente.sistema_de_seguridad_concurrente.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "SensorMovimientoes")
@Getter
@Setter
public class SensorMovimiento extends Sensor {

    @Column(length = 100)
    private String ubicacion;

    @OneToMany(mappedBy = "eventoss")
    private Set<Evento> sensorMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensior_id", nullable = false)
    private Usuario sensior;

}
