import { Injectable } from '@angular/core';
import { Category } from './category';
import { Question } from './Question';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Http, Response, Headers, RequestOptions} from "@angular/http";

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

addRecord(record){
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });
    let body = JSON.stringify(record);
    console.log('calling backend for save'+body);
    return this.http.post('http://localhost:8080/PersonalityWebApp/saveAnswer', body, options ).map((res: Response) => res.json());
   
} 



}