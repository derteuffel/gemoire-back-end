import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MemoiresService {

  URL: string;
  constructor(private http: HttpClient) { 
    this.URL = environment.url;
  }

// ajouterMemoire(): Observable<any> {
//     return this.http.put<any>(this.URL + `memoires`);
// }
AllMemoires() :Observable<any>{
    return this.http.get<any>(this.URL + 'memoires');

}

findByTitre(): Observable<any>{
    return this.http.get<any>(this.URL +'memoires/searchByTitre');
}

findByDiplome(): Observable<any>{
    return this.http.get<any>(this.URL +'memoires/searchByDiplome');
}

findByMotCles(): Observable<any>{
    return this.http.get<any>(this.URL +'memoires/searchByMotCles');
} 
 
findByEncadreur(): Observable<any>{
    return this.http.get<any>(this.URL +'memoires/searchByEncadreur');
} 

}
