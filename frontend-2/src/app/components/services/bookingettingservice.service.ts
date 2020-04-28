import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookingettingserviceService {

  constructor(private httpclient:HttpClient) { }



public getBooking(id){

return this.httpclient.get("http://localhost:9191/customer/getBookingByID/"+id);

}

public getLastRecord(id){

  return this.httpclient.get("http://localhost:9191/customer/findLastRecord/"+id);
}

}
