import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup, Validators } from '@angular/forms';
import { InputRowComponent } from 'app/common/input-row/input-row.component';
import { CredencialesService } from 'app/credenciales/credenciales.service';
import { CredencialesDTO } from 'app/credenciales/credenciales.model';
import { ErrorHandler } from 'app/common/error-handler.injectable';


@Component({
  selector: 'app-credenciales-add',
  standalone: true,
  imports: [CommonModule, RouterLink, ReactiveFormsModule, InputRowComponent],
  templateUrl: './credenciales-add.component.html'
})
export class CredencialesAddComponent {

  credencialesService = inject(CredencialesService);
  router = inject(Router);
  errorHandler = inject(ErrorHandler);

  addForm = new FormGroup({
    contrasenia: new FormControl(null, [Validators.required, Validators.maxLength(255)])
  }, { updateOn: 'submit' });

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      created: $localize`:@@credenciales.create.success:Credenciales was created successfully.`
    };
    return messages[key];
  }

  handleSubmit() {
    window.scrollTo(0, 0);
    this.addForm.markAllAsTouched();
    if (!this.addForm.valid) {
      return;
    }
    const data = new CredencialesDTO(this.addForm.value);
    this.credencialesService.createCredenciales(data)
        .subscribe({
          next: () => this.router.navigate(['/credencialess'], {
            state: {
              msgSuccess: this.getMessage('created')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error, this.addForm, this.getMessage)
        });
  }

}
