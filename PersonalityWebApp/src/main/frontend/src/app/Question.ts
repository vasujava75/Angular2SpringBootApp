export class Question {
    constructor(public id: number, 
      public question: string,
      public category: string,
      public questionType: string,
      public options: string
     ) { }
  }