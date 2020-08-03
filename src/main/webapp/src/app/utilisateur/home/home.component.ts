import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { SelectItem } from 'primeng/api';
import { FiliereService } from 'src/app/services/filiere.service';
import { MemoiresService } from 'src/app/services/memoires.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  val: Boolean;
  visibleSidebar1: Boolean;
  cities1: SelectItem[];
  binding: string;
  displayModal: boolean;
  display: boolean

  filiere: any[];
  memoire: any[];
  

  constructor(private _filiere: FiliereService,private _memoire:MemoiresService) { 

    this.cities1 = [
      {label:'Diplome', value:null},
      { 
        label:'Encadreur',
        value:{id:1, name: 'Encadreur', code: 'Encadreur'},
      },
      {label:'Titre', value:{id:2, name: 'Titre', code: 'Titre'}},
      {label:'Filiere', value:{id:3, name: 'Filiere', code: 'Filiere'}}
    ];
  }

  memoires : any[] = [
    {
      'titre': 'GESTION DES MEMOIRES EN LIGNE',
      'resume': 'Astuce Pour positionner votre site web lors de requête sur les moteurs de recherches, ces derniers analyses vos pages des plusieurs façons. Parmi elles, figure l’importance des mot-clés. Il est donc préférable de glisser un maximum de mot-clés dans la page (sans en faire trop, google le verrais et vous pénaliserais …)',
      'abstractMemoire':'Il arrive parfois lors de la création d’un site web d’ajouter certains liens par avance mais dont on ne connait encore pas l’adresse. Par sécurité, on ajoute comme valeur le symbole # (dièse) à l’attribut HREF de la balise <a>',
      'motsCles':'positionner,arrive,site,cadre',
      'session':'2019/2020',
      'nombreTelechargement':'20',
    }
   

  ];

  ngOnInit(): void {
    this.val = true;
    this.visibleSidebar1 = false;

    this._filiere.filiereAll().subscribe(f => {
      this.filiere = f.content;

      console.warn(this.filiere);
    });

    this._memoire.findByTitre().subscribe(m => {
      this.memoire = m.content;
      console.warn(this.memoire);
    });

    this._memoire.findByDiplome().subscribe(d => {
      this.memoire = d.content;
      console.warn(this.memoire);
    });

    this._memoire.findByEncadreur().subscribe(e => {
      this.memoire = e.content;
      console.warn(this.memoire);
    });
    
    this._memoire.AllMemoires().subscribe(a => {
      this.memoire = a.content;
      console.warn(this.memoire);
    });

  }

  showMenu(id1: string){
    this.val = !this.val;
    if (this.val) {
      $('#' + id1).addClass('open');
    }
    else{
      $('#' + id1).removeClass('open');
    }
  }

}
