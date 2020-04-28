import { Component, OnInit } from '@angular/core';
import {MoviegettingService } from '../services/moviegetting.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {


movies : {};

  constructor(private moviegettingService:MoviegettingService,private router : Router) { }

  ngOnInit() {

this.moviegettingService.getMovies().subscribe(data=>{

this.movies = data;

console.log(this.movies);


})

  }

}
