import { Component, OnInit } from '@angular/core';
import { BookingettingserviceService } from '../services/bookingettingservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orderreceipt',
  templateUrl: './orderreceipt.component.html',
  styleUrls: ['./orderreceipt.component.css']
})
export class OrderreceiptComponent implements OnInit {

  receipt : {};

  constructor(private ordergettingservice : BookingettingserviceService,private router :Router) { }

  ngOnInit() {

    //console.log(sessionStorage.getItem(''));

    if(sessionStorage.getItem('accessToken') != null){

    this.ordergettingservice.getLastRecord(parseInt(sessionStorage.getItem('userid'))).subscribe(
      lastRecorddata=>{

        console.log(lastRecorddata);
  this.receipt = lastRecorddata;
         

      },
      error=>{

     console.log(error);

      }
    )

    }

    else{


      alert("Please login to view this page")

      this.router.navigate(["/"]);
    }
  }

}
