import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class BackendService {
  constructor (
    private http: Http
  ) {}

  getCategories() {
    return this.http.get(`http://localhost:8080/PersonalityWebApp/getAllCategories`)
    .map((res:Response) => res.json());
  }
  getQuestions() {
    return this.http.get(`http://localhost:8080/PersonalityWebApp/getAllQuestionDetails`)
    .map((res:Response) => res.json());
  }

}