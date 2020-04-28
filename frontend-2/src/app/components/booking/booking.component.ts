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

Order : {};
user_id = parseInt(sessionStorage.getItem('userid'));

booking : Booking = new Booking(this.user_id,0,null,0,0,'',0);
//payment = this.booking.total;



movies : {};


constructor(private moviegettingservice : MoviegettingService,private usergettingservice : MoviebookingloginService,private router :Router) { }





ngOnInit() {



  if(sessionStorage.getItem('accessToken') != null){
  
this.moviegettingservice.getMovies().subscribe(data=>{


 


   this.movies = data;


   console.log(this.movies);
   
  
  

})
  }
  else{

  alert("Please login before you make the reservations!");
  this.router.navigate(["/login"]);

  }


  

this.usergettingservice.getUser(sessionStorage.getItem('username')).subscribe(userdata=>{

  //this.user = userdata;
  
 // console.log(this.user);

 console.log(sessionStorage.getItem('username'));
 
  sessionStorage.setItem('userid',userdata.id.toString());

  console.log(sessionStorage.getItem('userid'));

 


},usererror=>{


console.log(usererror);

})

}


public changePayment(){

  
this.booking.total =  (this.booking.adults * 500) + (this.booking.children * 250);

  
}

public insertBooking(){

  let datetime = new Date();
  let formdatetime = new Date(this.booking.checkin);

  console.log(datetime);

  if(formdatetime< datetime || this.booking.movieid === 0 || this.booking.time === "" || formdatetime === null){

    if(formdatetime< datetime || formdatetime == null){

      alert("Enter a Valid date");
      this.router.navigate(['/booking']);
    }

    if(this.booking.movieid == 0){

       alert("Please select a movie");
       this.router.navigate(['/booking']);
    }

    if(this.booking.time == ""){
       
      alert("Please select a time");
      this.router.navigate(["/booking"]);

    }

  }

  else{

    //console.log("true");
    //this.booking.customerid = parseInt( sessionStorage.getItem('userid'));

    this.moviegettingservice.insertBooking(this.booking).subscribe(
   
   
        Bookingdata=>{
   
         this.booking = Bookingdata;
         console.log(this.booking);
         alert("You have Reserved your seats successfully!");
   
        
        
   
         this.router.navigate(["/orderreceipt"]);
         
   
        },error=>{
   
          console.log(error);
          alert("Booking error!");
        }
   
   
   
    );
   


  }

 



}
   

  }

  

  



