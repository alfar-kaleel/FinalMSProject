import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MoviebookingloginService } from '../services/moviebookinglogin.service';

@Component({
  selector: 'app-admin-view-profile',
  templateUrl: './admin-view-profile.component.html',
  styleUrls: ['./admin-view-profile.component.css']
})
export class AdminViewProfileComponent implements OnInit {

users:{};

  constructor(private router: Router,private usergettingservice:MoviebookingloginService) { }

  ngOnInit() {

    if(sessionStorage.getItem('role') != "ROLE_admin" || sessionStorage.getItem('accessToken') == null){

      alert("Please sign in as admin");
      this.router.navigate(["/login"]);
 
              
     }
 this.usergettingservice.getAllUsers().subscribe(

  data=>{
 
    this.users= data;
   console.log(this.users)

  },

  error=>{


  }
 )
     
 
  }


  

}
