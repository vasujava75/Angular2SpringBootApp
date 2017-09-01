import { Component } from '@angular/core';
import { BackendService } from './BackendService';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private backendService: BackendService) {}
  title = '67';
  profile = {};
  loadData(){
  this.backendService.getQuestions().subscribe(data => this.profile = data);;
  }
}
