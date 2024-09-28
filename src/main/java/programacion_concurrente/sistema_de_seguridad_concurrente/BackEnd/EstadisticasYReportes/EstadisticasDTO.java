package programacion_concurrente.sistema_de_seguridad_concurrente.BackEnd.EstadisticasYReportes;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EstadisticasDTO {

    private int totalEventosSeguridad;

    private int accesosDenegados;

    private int alertasTemperatura;

    @NotNull
    private String sensorMovimiento;

    @NotNull
    private String sensorTemperatura;

    // Constructor
    public EstadisticasDTO(int totalEventosSeguridad, int accesosDenegados, int alertasTemperatura, String sensorMovimiento, String sensorTemperatura) {
        this.totalEventosSeguridad = totalEventosSeguridad;
        this.accesosDenegados = accesosDenegados;
        this.alertasTemperatura = alertasTemperatura;
        this.sensorMovimiento = sensorMovimiento;
        this.sensorTemperatura = sensorTemperatura;
    }
}
