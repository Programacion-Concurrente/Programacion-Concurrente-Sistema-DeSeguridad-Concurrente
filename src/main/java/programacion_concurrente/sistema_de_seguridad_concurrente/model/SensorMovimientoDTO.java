package programacion_concurrente.sistema_de_seguridad_concurrente.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
public class SensorMovimientoDTO {

    private Integer idSensor;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @Size(max = 100)
    private String ubicacion;

    @NotNull
    private Integer sensior;
}
