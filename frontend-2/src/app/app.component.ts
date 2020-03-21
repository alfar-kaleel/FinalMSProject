import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Movie Booking';

  constructor(private router: Router){}

  ngOnInit(): void {
  }

  isReload() {
    

   if (this.router.url === '/'){

       return true;
   }

   else {

    return false;
   }
  }

}
