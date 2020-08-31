import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { MemoiresService } from '../services/memoires.service';
import {Observable} from "rxjs";
import {Memoire} from "../_models/memoire";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  content: string;
  memoires:Observable<any[]>;
  constructor(private adminService: AdminService,
              private memoiresService: MemoiresService) { }

  ngOnInit(): void {
      this.loadAll();
    this.adminService.getModeratorBoard().subscribe(
        data => {
          this.content = data;
        },
        err => {
          this.content = JSON.parse(err.error).message;
        }
    );
  }

  loadAll(){
      this.memoires= this.memoiresService.findAllMemoires();
      console.log(this.memoires);
  }

}
