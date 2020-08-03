import { Component, OnInit } from '@angular/core';
import { FiliereService } from 'src/app/services/filiere.service';


@Component({
  selector: 'app-memoire',
  templateUrl: './memoire.component.html',
  styleUrls: ['./memoire.component.scss']
})
export class MemoireComponent implements OnInit {

  filiere: any[];
  displayModal: boolean;
  display: boolean;

  constructor(private _filiere: FiliereService) { }

  ngOnInit(): void {

    this._filiere.filiereAll().subscribe(f => {
      this.filiere = f.content;

      console.warn(this.filiere);
    });
  }
  memoires : any[] = [
    {
      'titre': 'GESTION DES MEMOIRES EN LIGNE',
      'resume': 'Astuce : Pour positionner votre site web lors de requête sur les moteurs de recherches, ces derniers analyses vos pages des plusieurs façons. Parmi elles, figure l’importance des mot-clés. Il est donc préférable de glisser un maximum de mot-clés dans la page (sans en faire trop, google le verrais et vous pénaliserais …)',
      'abstractMemoire':'Il arrive parfois lors de la création d’un site web d’ajouter certains liens par avance mais dont on ne connait encore pas l’adresse. Par sécurité, on ajoute comme valeur le symbole # (dièse) à l’attribut HREF de la balise <a>',
      'motsCles':'positionner,arrive,site,cadre',
      'session':'2019/2020',
      'nombreTelechargement':'20',
    }
   

  ];

}
