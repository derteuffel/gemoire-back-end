import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import{AuthComponent} from  './admin/auth/auth.component';
import { from } from 'rxjs';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import {HomeComponent} from "./home/home.component";
import {NewMemoireComponent} from "./new-memoire/new-memoire.component";


const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/'
  },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'home/new-memoire', component: NewMemoireComponent },

  {
    path: 'admin',
    loadChildren: () => import('./admin/admin.module').then(mod => mod.AdminModule)
  }
];


// const routes: Routes = [
//   {
// //     path: '',
//  // component: HomeComponent
//  path: '', 
//  pathMatch: 'full',
//  redirectTo: 'utilisateur'
//   },
//   {
//     path: 'utilisateur',
//     loadChildren: () => UtilisateurModule
//   },
//   {
//     path: 'admin',
//     loadChildren: () => AdminModule
//   }
  
// ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
