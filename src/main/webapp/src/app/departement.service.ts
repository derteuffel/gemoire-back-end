import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  constructor(private http: HttpClient) { }

    listAll(): Observable<any> {
      return this.http.get<any>(`http://localhost:8080/api/departements`);
    }

  
}
