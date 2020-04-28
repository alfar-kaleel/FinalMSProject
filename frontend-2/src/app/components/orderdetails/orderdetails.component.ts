import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { BookingettingserviceService } from '../services/bookingettingservice.service';

@Component({
  selector: 'app-orderdetails',
  templateUrl: './orderdetails.component.html',
  styleUrls: ['./orderdetails.component.css']
})
export class OrderdetailsComponent implements OnInit {

  bookings : {}

  constructor(private router : Router,private bookinggettingService:BookingettingserviceService) { }

  ngOnInit() {

    if(sessionStorage.getItem('accessToken') == null){

      alert("Please login to access this page");

      this.router.navigate(["/"]);
       

    }


    this.bookinggettingService.getBooking(parseInt(sessionStorage.getItem('userid'))).subscribe(

      bookingdata=>{

    this.bookings = bookingdata;

    console.log(bookingdata);

      },error=>{

  console.log(error);

      }
    )





  }

}
