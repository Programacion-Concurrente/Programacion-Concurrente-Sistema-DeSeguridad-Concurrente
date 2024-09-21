package programacion_concurrente.sistema_de_seguridad_concurrente.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Eventoes")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Evento {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvento;

    @Column(length = 50)
    private String nivelCriticidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventos_id", nullable = false)
    private SensorTemperatura eventos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventoss_id", nullable = false)
    private SensorMovimiento eventoss;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventosss_id", nullable = false)
    private SensorAcceso eventosss;

    @OneToOne(mappedBy = "notificacion", fetch = FetchType.LAZY)
    private Notificacion evento;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
