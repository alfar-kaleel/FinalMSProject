import { Component, OnInit } from '@angular/core';
import { Customer, Address, HttpCliService, Telephone } from '../services/http-cli.service';
import { HttpClient } from '@angular/common/http';
import { error } from 'util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  address: Address = new Address("");
  telephone: Telephone=new Telephone("");

  user: Customer = new Customer('',0,'','',this.address,null,'');


  constructor(private httpCliService : HttpCliService,private router : Router) { }



 


  ngOnInit() {
  }

  createEmployee(): void {
    this.httpCliService.createEmployee(this.user)
        .subscribe( data => {
          console.log(this.user);
          alert("Employee created successfully.");
          this.router.navigate(["/login"])
          
        }, error => {
          console.log(this.user);
          console.log(error);
          alert("Employee registration error");
        });

  }; 

} 
