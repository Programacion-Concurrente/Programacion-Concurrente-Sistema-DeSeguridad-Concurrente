import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { RolListComponent } from './rol/rol-list.component';
import { RolAddComponent } from './rol/rol-add.component';
import { RolEditComponent } from './rol/rol-edit.component';
import { UsuarioListComponent } from './usuario/usuario-list.component';
import { UsuarioAddComponent } from './usuario/usuario-add.component';
import { UsuarioEditComponent } from './usuario/usuario-edit.component';
import { EventoListComponent } from './evento/evento-list.component';
import { EventoAddComponent } from './evento/evento-add.component';
import { EventoEditComponent } from './evento/evento-edit.component';
import { NotificacionListComponent } from './notificacion/notificacion-list.component';
import { NotificacionAddComponent } from './notificacion/notificacion-add.component';
import { NotificacionEditComponent } from './notificacion/notificacion-edit.component';
import { SensorTemperaturaListComponent } from './sensor-temperatura/sensor-temperatura-list.component';
import { SensorTemperaturaAddComponent } from './sensor-temperatura/sensor-temperatura-add.component';
import { SensorTemperaturaEditComponent } from './sensor-temperatura/sensor-temperatura-edit.component';
import { SensorAccesoListComponent } from './sensor-acceso/sensor-acceso-list.component';
import { SensorAccesoAddComponent } from './sensor-acceso/sensor-acceso-add.component';
import { SensorAccesoEditComponent } from './sensor-acceso/sensor-acceso-edit.component';
import { SensorMovimientoListComponent } from './sensor-movimiento/sensor-movimiento-list.component';
import { SensorMovimientoAddComponent } from './sensor-movimiento/sensor-movimiento-add.component';
import { SensorMovimientoEditComponent } from './sensor-movimiento/sensor-movimiento-edit.component';
import { CredencialesListComponent } from './credenciales/credenciales-list.component';
import { CredencialesAddComponent } from './credenciales/credenciales-add.component';
import { CredencialesEditComponent } from './credenciales/credenciales-edit.component';
import { ErrorComponent } from './error/error.component';


export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    title: $localize`:@@home.index.headline:Welcome to your new app!`
  },
  {
    path: 'rols',
    component: RolListComponent,
    title: $localize`:@@rol.list.headline:Rols`
  },
  {
    path: 'rols/add',
    component: RolAddComponent,
    title: $localize`:@@rol.add.headline:Add Rol`
  },
  {
    path: 'rols/edit/:idRol',
    component: RolEditComponent,
    title: $localize`:@@rol.edit.headline:Edit Rol`
  },
  {
    path: 'usuarios',
    component: UsuarioListComponent,
    title: $localize`:@@usuario.list.headline:Usuarios`
  },
  {
    path: 'usuarios/add',
    component: UsuarioAddComponent,
    title: $localize`:@@usuario.add.headline:Add Usuario`
  },
  {
    path: 'usuarios/edit/:idUsuario',
    component: UsuarioEditComponent,
    title: $localize`:@@usuario.edit.headline:Edit Usuario`
  },
  {
    path: 'eventos',
    component: EventoListComponent,
    title: $localize`:@@evento.list.headline:Eventoes`
  },
  {
    path: 'eventos/add',
    component: EventoAddComponent,
    title: $localize`:@@evento.add.headline:Add Evento`
  },
  {
    path: 'eventos/edit/:idEvento',
    component: EventoEditComponent,
    title: $localize`:@@evento.edit.headline:Edit Evento`
  },
  {
    path: 'notificacions',
    component: NotificacionListComponent,
    title: $localize`:@@notificacion.list.headline:Notificacions`
  },
  {
    path: 'notificacions/add',
    component: NotificacionAddComponent,
    title: $localize`:@@notificacion.add.headline:Add Notificacion`
  },
  {
    path: 'notificacions/edit/:idNotificacion',
    component: NotificacionEditComponent,
    title: $localize`:@@notificacion.edit.headline:Edit Notificacion`
  },
  {
    path: 'sensorTemperaturas',
    component: SensorTemperaturaListComponent,
    title: $localize`:@@sensorTemperatura.list.headline:Sensor Temperaturas`
  },
  {
    path: 'sensorTemperaturas/add',
    component: SensorTemperaturaAddComponent,
    title: $localize`:@@sensorTemperatura.add.headline:Add Sensor Temperatura`
  },
  {
    path: 'sensorTemperaturas/edit/:idSensor',
    component: SensorTemperaturaEditComponent,
    title: $localize`:@@sensorTemperatura.edit.headline:Edit Sensor Temperatura`
  },
  {
    path: 'sensorAccesos',
    component: SensorAccesoListComponent,
    title: $localize`:@@sensorAcceso.list.headline:Sensor Accesoes`
  },
  {
    path: 'sensorAccesos/add',
    component: SensorAccesoAddComponent,
    title: $localize`:@@sensorAcceso.add.headline:Add Sensor Acceso`
  },
  {
    path: 'sensorAccesos/edit/:idSensor',
    component: SensorAccesoEditComponent,
    title: $localize`:@@sensorAcceso.edit.headline:Edit Sensor Acceso`
  },
  {
    path: 'sensorMovimientos',
    component: SensorMovimientoListComponent,
    title: $localize`:@@sensorMovimiento.list.headline:Sensor Movimientoes`
  },
  {
    path: 'sensorMovimientos/add',
    component: SensorMovimientoAddComponent,
    title: $localize`:@@sensorMovimiento.add.headline:Add Sensor Movimiento`
  },
  {
    path: 'sensorMovimientos/edit/:idSensor',
    component: SensorMovimientoEditComponent,
    title: $localize`:@@sensorMovimiento.edit.headline:Edit Sensor Movimiento`
  },
  {
    path: 'credencialess',
    component: CredencialesListComponent,
    title: $localize`:@@credenciales.list.headline:Credencialeses`
  },
  {
    path: 'credencialess/add',
    component: CredencialesAddComponent,
    title: $localize`:@@credenciales.add.headline:Add Credenciales`
  },
  {
    path: 'credencialess/edit/:nombre',
    component: CredencialesEditComponent,
    title: $localize`:@@credenciales.edit.headline:Edit Credenciales`
  },
  {
    path: 'error',
    component: ErrorComponent,
    title: $localize`:@@error.headline:Error`
  },
  {
    path: '**',
    component: ErrorComponent,
    title: $localize`:@@notFound.headline:Page not found`
  }
];
