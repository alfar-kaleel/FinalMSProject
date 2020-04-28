import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MoviegettingService, Movie } from '../services/moviegetting.service';

@Component({
  selector: 'app-admin-add-movie',
  templateUrl: './admin-add-movie.component.html',
  styleUrls: ['./admin-add-movie.component.css']
})
export class AdminAddMovieComponent implements OnInit {

  movies : {};
  id;

  constructor(private router: Router,private moviegettingservice :MoviegettingService) { }

  ngOnInit() {

    if(sessionStorage.getItem('role') != "ROLE_admin" || sessionStorage.getItem('accessToken') == null){

      alert("Please sign in as admin");
      this.router.navigate(["/login"]);
 

              
     }


     
     this.moviegettingservice.getMovies().subscribe(

      data=>{

        console.log(data);
        this.movies = data; 


      }
     )
 
  }


  public deleteMovie(){

   this.moviegettingservice.deleteMovie(this.id).subscribe(

    data=>{
      alert("Successfully deleted the movie");

    }

    ,error=>{

      alert("No such id found");
    }
   )

  }

}
