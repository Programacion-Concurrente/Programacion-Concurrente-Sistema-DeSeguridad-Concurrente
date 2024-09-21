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
@Table(name = "SensorAccesoes")
@Getter
@Setter
public class SensorAcceso extends Sensor {

    @Column(length = 100)
    private String ubicacion;

    @Column(nullable = false)
    private String respuesta;

    @OneToMany(mappedBy = "eventosss")
    private Set<Evento> sensorAcceso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sens_id", nullable = false)
    private Usuario sens;

}
