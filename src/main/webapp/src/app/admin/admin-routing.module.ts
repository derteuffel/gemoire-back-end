import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth/auth.component';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { HomeComponent } from '../utilisateur/home/home.component';
import { MemoireComponent } from '../utilisateur/memoire/memoire.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'auth', pathMatch: 'full'
  },
  {
    path: 'auth', component: AuthComponent
  },
  {
    path: 'acceuil', component: AcceuilComponent
  }
  
  ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
