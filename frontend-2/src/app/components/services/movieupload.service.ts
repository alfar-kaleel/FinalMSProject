import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Movie{

  constructor(

  public name : String,
  public language :Array<Language>
  
  ){}
  
  }
  
  export class Language{
  
  
  constructor(
  
  public name : String
  
  
  ){}
  
  }

@Injectable({
  providedIn: 'root'
})
export class MovieuploadService {

  constructor(private httpclient : HttpClient) { }



  public uploadMovie(movie){

  return this.httpclient.post<any>("http://localhost:9192/Movie/insertMovie?access_token="+sessionStorage.getItem('accessToken'),movie);

  }
}
