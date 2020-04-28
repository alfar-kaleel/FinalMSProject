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

export class Movie{

constructor(
public id : number,
public name : String,
public language : Language,
public image : any

){}

}

export class Language{


constructor(
public languageid : number,
public languagename : String


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


 return this.httpclient.get<Movie>("http://localhost:9192/Movie/findAllMovies?access_token=" + sessionStorage.getItem('accessToken'));

}

public deleteMovie(id){

  return this.httpclient.delete("http://localhost:9192/Movie/deleteMovie/"+id+"?access_token=" + sessionStorage.getItem('accessToken'))
}




}
