import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Memoire} from "../_models/memoire";
import {MemoiresService} from "../services/memoires.service";
import {TokenStorageService} from "../services/token-storage.service";

@Component({
  selector: 'app-new-memoire',
  templateUrl: './new-memoire.component.html',
  styleUrls: ['./new-memoire.component.scss']
})
export class NewMemoireComponent implements OnInit {

  memoire:Memoire = new Memoire();
  isLoggedIn=false;
  constructor(private memoiresService:MemoiresService,
              private router:Router,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
  }

  save(){
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn){
      this.memoiresService.saveMemoire(this.memoire)
          .subscribe(
              data => {
                console.log(data);
              },
              error => console.log(error)
          );

      this.memoire = new Memoire();
      this.router.navigate(['home']);
    }

  }

  onSubmit(){
    this.save();
  }

}
