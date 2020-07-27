import { Component, OnInit } from '@angular/core';
import { DepartementService } from '../../departement.service';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.scss']
})
export class ListeComponent implements OnInit {

  departements : any[] = [
    {
      'codeDepartement': 'GCA',
      'intituleDepartement': 'Genie Civil et Architecture'
    },
    {
      'codeDepartement': 'SCIENV',
      'intituleDepartement': 'Sciences Environnementales'
    }

  ];

  constructor(private _service: DepartementService) { 

      this._service.listAll().subscribe(a => {
          this.departements = a.content;
      });

  }

  ngOnInit(): void {
  }

}
