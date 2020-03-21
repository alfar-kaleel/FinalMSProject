import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';


export class Booking {

constructor(
public customerid :number,
public movieid : number,
public checkin : Date,
public adults : number,
public children : number,
public time : String,
public total : number

){}



}




@Injectable({
  providedIn: 'root'
})
export class MoviegettingService {

  constructor(private httpclient : HttpClient) { }



public insertBooking(booking){

  return this.httpclient.post<Booking>("http://localhost:9191/customer/insertBooking",booking);
}  


public getMovies(){


 return this.httpclient.get("http://localhost:9192/Movie/findAllMovies");

}




}
