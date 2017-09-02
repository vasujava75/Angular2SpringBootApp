import { Component,OnInit  } from '@angular/core';
import { BackendService } from './BackendService';
import { Category } from './category';
import { Question } from './Question';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit { 
  constructor(private backendService: BackendService) {
   
   
  }
  title = '67';
  
  errorMessage: String;
  selectedCategory:String;
  selectedQuestion:String; 
  categories: Category[];
  questions:Question[];

  ngOnInit(): void {
    this.backendService.getCategories().subscribe(
        categories => this.categories = categories,
        error =>  this.errorMessage = <any>error);
       
    
    this.backendService.getQuestions('hard_fact').subscribe(
      questions => this.questions = questions,
      error =>  this.errorMessage = <any>error);
     
}
  
  loadQuestionOnSelect(categoryName){
    this.backendService.getQuestions(categoryName).subscribe(
      questions => this.questions = questions,
      error =>  this.errorMessage = <any>error);
      console.log(this.questions);
  }
  

 
}
