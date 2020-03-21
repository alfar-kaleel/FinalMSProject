import { Component, OnInit } from '@angular/core';
import {MoviegettingService,Booking} from '../services/moviegetting.service';
import {MoviebookingloginService} from '../services/moviebookinglogin.service';
import { FormGroup, FormControl } from '@angular/forms';
import {Router} from '@angular/router'








@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {



user_id = parseInt(sessionStorage.getItem('userid'));

booking : Booking = new Booking(this.user_id,0,null,0,0,'',0);
//payment = this.booking.total;




movies : {};


constructor(private moviegettingservice : MoviegettingService,private usergettingservice : MoviebookingloginService,private router :Router) { }





ngOnInit() {


  
this.moviegettingservice.getMovies().subscribe(data=>{

 
//var payment = document.getElementById("payment");



   this.movies = data;


   console.log(this.movies);
   
   
  

})



this.usergettingservice.getUser(sessionStorage.getItem('username')).subscribe(userdata=>{

  //this.user = userdata;
  
 // console.log(this.user);

 
  sessionStorage.setItem('userid',userdata.id.toString());

},usererror=>{


console.log(usererror);

})

}


public changePayment(){

  
this.booking.total =  (this.booking.adults * 500) + (this.booking.children * 250);

  
}

public insertBooking(){


 this.moviegettingservice.insertBooking(this.booking).subscribe(


     Bookingdata=>{

      this.booking = Bookingdata;
      console.log(this.booking);
      alert("You have Reserved your seats successfully!");

      this.router.navigate(["/home"]);
      

     },error=>{

       console.log(error);
       alert("Booking error!");
     }



 );

};
   

  }

  

  



