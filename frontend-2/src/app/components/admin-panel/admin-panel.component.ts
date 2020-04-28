import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MovieuploadService } from '../services/movieupload.service';
import { Movie } from '../services/movieupload.service';
import { Language } from '../services/movieupload.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  language : Language = new Language("");
  movie :Movie = new Movie("",[this.language]);
  SelectedFile : File;

  constructor(private router : Router,private movieuploadService : MovieuploadService) { }

  ngOnInit() {

    if(sessionStorage.getItem('role') != "ROLE_admin" || sessionStorage.getItem('accessToken') == null){

     alert("Please sign in as admin");
     this.router.navigate(["/login"]);

             
    }

    


    
  }


  public onFileChanged(event) {
    //Select File
    this.SelectedFile = event.target.files[0];
  }

  async addMovie(){


    const uploadMovie = new FormData();

    uploadMovie.append('movies',JSON.stringify(this.movie));


     uploadMovie.append('image',this.SelectedFile,this.SelectedFile.name);
    

   

    this.movieuploadService.uploadMovie(uploadMovie).subscribe(uploaddata =>{


      console.log(uploaddata);
      alert("SuccessFully uploaded the movie");

    },
  error=>{

console.log(error);
alert("Fill the datas,upload an image and try again");

  })


  }

}
