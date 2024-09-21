package programacion_concurrente.sistema_de_seguridad_concurrente.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.Evento;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.Notificacion;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorAcceso;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorMovimiento;
import programacion_concurrente.sistema_de_seguridad_concurrente.domain.SensorTemperatura;
import programacion_concurrente.sistema_de_seguridad_concurrente.model.EventoDTO;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.EventoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.NotificacionRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorAccesoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorMovimientoRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.repos.SensorTemperaturaRepository;
import programacion_concurrente.sistema_de_seguridad_concurrente.util.NotFoundException;
import programacion_concurrente.sistema_de_seguridad_concurrente.util.ReferencedWarning;


@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final SensorTemperaturaRepository sensorTemperaturaRepository;
    private final SensorMovimientoRepository sensorMovimientoRepository;
    private final SensorAccesoRepository sensorAccesoRepository;
    private final NotificacionRepository notificacionRepository;

    public EventoService(final EventoRepository eventoRepository,
            final SensorTemperaturaRepository sensorTemperaturaRepository,
            final SensorMovimientoRepository sensorMovimientoRepository,
            final SensorAccesoRepository sensorAccesoRepository,
            final NotificacionRepository notificacionRepository) {
        this.eventoRepository = eventoRepository;
        this.sensorTemperaturaRepository = sensorTemperaturaRepository;
        this.sensorMovimientoRepository = sensorMovimientoRepository;
        this.sensorAccesoRepository = sensorAccesoRepository;
        this.notificacionRepository = notificacionRepository;
    }

    public List<EventoDTO> findAll() {
        final List<Evento> eventoes = eventoRepository.findAll(Sort.by("idEvento"));
        return eventoes.stream()
                .map(evento -> mapToDTO(evento, new EventoDTO()))
                .toList();
    }

    public EventoDTO get(final Integer idEvento) {
        return eventoRepository.findById(idEvento)
                .map(evento -> mapToDTO(evento, new EventoDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final EventoDTO eventoDTO) {
        final Evento evento = new Evento();
        mapToEntity(eventoDTO, evento);
        return eventoRepository.save(evento).getIdEvento();
    }

    public void update(final Integer idEvento, final EventoDTO eventoDTO) {
        final Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(NotFoundException::new);
        mapToEntity(eventoDTO, evento);
        eventoRepository.save(evento);
    }

    public void delete(final Integer idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    private EventoDTO mapToDTO(final Evento evento, final EventoDTO eventoDTO) {
        eventoDTO.setIdEvento(evento.getIdEvento());
        eventoDTO.setNivelCriticidad(evento.getNivelCriticidad());
        eventoDTO.setEventos(evento.getEventos() == null ? null : evento.getEventos().getIdSensor());
        eventoDTO.setEventoss(evento.getEventoss() == null ? null : evento.getEventoss().getIdSensor());
        eventoDTO.setEventosss(evento.getEventosss() == null ? null : evento.getEventosss().getIdSensor());
        return eventoDTO;
    }

    private Evento mapToEntity(final EventoDTO eventoDTO, final Evento evento) {
        evento.setNivelCriticidad(eventoDTO.getNivelCriticidad());
        final SensorTemperatura eventos = eventoDTO.getEventos() == null ? null : sensorTemperaturaRepository.findById(eventoDTO.getEventos())
                .orElseThrow(() -> new NotFoundException("eventos not found"));
        evento.setEventos(eventos);
        final SensorMovimiento eventoss = eventoDTO.getEventoss() == null ? null : sensorMovimientoRepository.findById(eventoDTO.getEventoss())
                .orElseThrow(() -> new NotFoundException("eventoss not found"));
        evento.setEventoss(eventoss);
        final SensorAcceso eventosss = eventoDTO.getEventosss() == null ? null : sensorAccesoRepository.findById(eventoDTO.getEventosss())
                .orElseThrow(() -> new NotFoundException("eventosss not found"));
        evento.setEventosss(eventosss);
        return evento;
    }

    public ReferencedWarning getReferencedWarning(final Integer idEvento) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(NotFoundException::new);
        final Notificacion notificacionNotificacion = notificacionRepository.findFirstByNotificacion(evento);
        if (notificacionNotificacion != null) {
            referencedWarning.setKey("evento.notificacion.notificacion.referenced");
            referencedWarning.addParam(notificacionNotificacion.getIdNotificacion());
            return referencedWarning;
        }
        return null;
    }

}
