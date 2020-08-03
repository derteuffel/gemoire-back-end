import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { AuthComponent } from './auth/auth.component';


@NgModule({
  declarations: [AcceuilComponent, AuthComponent],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
