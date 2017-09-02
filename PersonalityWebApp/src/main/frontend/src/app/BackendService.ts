import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';

import { Category } from './category';
import { Question } from './Question';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class BackendService {
  constructor (
    private http: Http
  ) {}

 
  getQuestions(category: String): Observable<Question[]>  {
    return this.http.get(`http://localhost:8080/PersonalityWebApp/getAllQuestionDetails/`+category)
    .map(this.extractData)
    .catch(this.handleErrorObservable);
  }
  private extractData(res: Response) {
    let body = res.json();
    return body;
} 
private handleErrorObservable (error: Response | any) {
  console.error(error.message || error);
  return Observable.throw(error.message || error);
} 

getCategories(): Observable<Category[]> {
    return this.http.get(`http://localhost:8080/PersonalityWebApp/getAllCategories`)
        .map(this.extractData)
        .catch(this.handleErrorObservable);
} 



}