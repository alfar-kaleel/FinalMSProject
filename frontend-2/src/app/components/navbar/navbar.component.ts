import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router :Router) { }

  ngOnInit() {
  }


  signoutUser(){

    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('refreshToken');
     this.router.navigate(['/']);

    

  }

   signoutLoad(){

   if(sessionStorage.getItem('accessToken') != null){


    return true;
   }

   
   }


   homeLoad(){

    if(this.router.url === '/'){

      return false;
    }
  else{

    return true;
  }

   }

   profileLoad(){

    if (sessionStorage.getItem('accessToken') == null || this.router.url === '/profile'){

     return false;

    }
    else{

      return true;
    }
 
    }


  loginLoad(){

  if(this.router.url === '/login' || sessionStorage.getItem('accessToken') != null){


 return false; 

}

  

  else{

     return true;
  }
}

}
