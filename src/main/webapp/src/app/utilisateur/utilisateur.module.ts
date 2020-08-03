import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UtilisateurRoutingModule } from './utilisateur-routing.module';
import { HomeComponent } from './home/home.component';
import { MemoireComponent } from './memoire/memoire.component';
import { from } from 'rxjs';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {CardModule} from 'primeng/card';
import {SidebarModule} from 'primeng/sidebar';
import {FieldsetModule} from 'primeng/fieldset';
import {PanelModule} from 'primeng/panel';

@NgModule({
  declarations: [HomeComponent, MemoireComponent],
  
  imports: [
    CommonModule,
    UtilisateurRoutingModule,
    CardModule,
    SidebarModule,
    ButtonModule,
    DropdownModule,
    FieldsetModule,
    PanelModule
  ]
})
export class UtilisateurModule { }
