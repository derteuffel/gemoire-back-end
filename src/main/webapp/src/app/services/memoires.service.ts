import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import {Memoire} from "../_models/memoire";

const MEMOIRE_API = 'http://localhost:8080/rest/memoire/';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class MemoiresService {

    constructor(private http: HttpClient) { }

    findAllMemoires(): Observable<any>{
        return this.http.get(MEMOIRE_API+'lists');
    }

    saveMemoire(memoire:any): Observable<any>{
        return this.http.post(MEMOIRE_API+'save',memoire);
    }



}
