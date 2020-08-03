import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { MemoireComponent } from './memoire/memoire.component';


const routes: Routes = [
  {
    path: '', redirectTo: 'home', pathMatch: 'full'
  },
  {
    path: 'home', component:HomeComponent},
    //  children: [
      //  {path: '', redirectTo: 'memoire', pathMatch: 'full'},
    {path: 'memoire', component: MemoireComponent}
    // ]
  // }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UtilisateurRoutingModule { }
