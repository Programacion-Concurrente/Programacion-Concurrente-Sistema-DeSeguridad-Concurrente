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

    private String NivelCriticidad;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(nullable = false)
    private OffsetDateTime fechaHora;

    @Column(nullable = false)
    private String tipoEvento;

    @Column(nullable = false)
    private String descripcion;

}
