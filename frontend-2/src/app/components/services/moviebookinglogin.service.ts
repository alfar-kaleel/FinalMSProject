import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class APIResponse {
  constructor(public status: number,
              public message: string,
              public accessToken: AccessToken) {
  }
}

export class User{

constructor(public id :number,
            public name : String,
            public age : number,
            public gender :String,
            public email :String,
            public address :Address,
            public telephone : Telephone
            
            ){}
            
}

export class Address {
  constructor(public city: string) {
  }
}

export class Telephone {
  constructor(public phoneNumber: string){

  }
}
export class AccessToken {
  constructor(public access_token: string,
              public token_type: string,
              public refresh_token: string,
              public expires_in: number,
              public scope: string) {
  }
}


@Injectable({
  providedIn: 'root'
})
export class MoviebookingloginService {

  constructor(private httpClient: HttpClient) { }

  public authenticate(username, password) {
    return this.httpClient.get<APIResponse>('http://localhost:9191/customer/login/' + username + '/' + password);
  }

  


  public getUser(username){

   return this.httpClient.get<User>('http://localhost:9191/customer/getUser/' + username);

  }

  public isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    return !(user === null);
  }

  public logout() {
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('accessToken');
    sessionStorage.removeItem('refreshToken');
  }
}