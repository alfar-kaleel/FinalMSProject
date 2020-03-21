import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Customer {
  constructor(
    public username:string,
    public age:number,
    public gender:string,
    public email:string,
    public address: Address,
    public telephone: Array<Telephone>,
    public password: String

  ) {}
  
}

export class Address {
  constructor(public city: string) {
  }
}

export class Telephone {
  constructor(public phoneNumber: string){

  }
}


@Injectable({
  providedIn: 'root'
})
export class HttpCliService {

  constructor(private httpClient:HttpClient) { }


  public createEmployee(customer) {
    return this.httpClient.post<Customer>("http://localhost:9191/customer/add", customer);
  }


}
