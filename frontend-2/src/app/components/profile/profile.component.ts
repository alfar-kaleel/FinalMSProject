import { Component, OnInit } from '@angular/core';
import { MoviebookingloginService } from '../services/moviebookinglogin.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {


  profiles : {};

  constructor(private usergetting : MoviebookingloginService) { }

  ngOnInit() {

 this.usergetting.getUser(sessionStorage.getItem('username')).subscribe(

profiledata=>{
   this.profiles = profiledata;
   console.log(this.profiles);
   console.log(profiledata.roles[0].name)

})

  }

}
