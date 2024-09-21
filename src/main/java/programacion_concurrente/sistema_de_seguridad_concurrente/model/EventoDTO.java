package programacion_concurrente.sistema_de_seguridad_concurrente.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventoDTO {

    private Integer idEvento;

    @Size(max = 50)
    private String nivelCriticidad;

    @NotNull
    private Integer eventos;

    @NotNull
    private Integer eventoss;

    @NotNull
    private Integer eventosss;

}
