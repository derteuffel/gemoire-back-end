import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FiliereService {

  URL: string;
  constructor(private http: HttpClient) { 
    this.URL = environment.url;
  }

  filiereAll(): Observable<any> {
    return this.http.get<any>(this.URL + `filieres`);
  }
}
