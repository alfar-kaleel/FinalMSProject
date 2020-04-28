import { Component, OnInit } from '@angular/core';
import { APIResponse, MoviebookingloginService } from '../services/moviebookinglogin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  

  username;
  password;
  invalidLogin = false;
  apiResponse: APIResponse;
  profile : {};
  
  constructor(private router: Router, private movieBookingService: MoviebookingloginService) { }

  ngOnInit() {

if(sessionStorage.getItem('accessToken') != null){

this.router.navigate(["/"]);

}


  }

 // goToHome() {
   // window.location.href = 'http://' + window.location.hostname + ':' + window.location.port;}

  loginUser(): void {

    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('refreshToken');
    this.movieBookingService.authenticate(this.username, this.password).subscribe(data => {
      //this.apiResponse = data;

       console.log(data);

      if (data.message === " Login Successful!"){
        sessionStorage.setItem('username', this.username);
        sessionStorage.setItem('accessToken', data.accessToken.access_token);
        sessionStorage.setItem('refreshToken', data.accessToken.refresh_token);

        this.movieBookingService.getUser(this.username).subscribe(userdata =>{

          //this.profile = userdata;
          console.log(userdata.roles[0].name);
          console.log(sessionStorage.getItem('username'));
          console.log(userdata.id);
          sessionStorage.setItem('role', userdata.roles[0].name);
          sessionStorage.setItem('userid',userdata.id.toString());

          if(userdata.roles[0].name === "ROLE_operator"){
           
            
            alert("You are logged in as Customer");
      
             this.router.navigate(["/movie"]);
            

          }

          if(userdata.roles[0].name === "ROLE_admin"){

            alert("You are logged in as admin");

            this.router.navigate(["/admin"]);
          }

        })

    
       
      }


      else{

        alert("Login failure!Check your username,password and try again");

        console.log(data);
      }


    }, error => {

      
      console.log(error);
      this.invalidLogin = true;
    });
  }
}