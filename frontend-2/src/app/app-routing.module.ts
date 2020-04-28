import { NgModule, Component } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RequestResetComponent } from './components/password/request-reset/request-reset.component';
import { ResponseResetComponent } from './components/password/response-reset/response-reset.component';
import {BookingComponent} from './components/booking/booking.component';
import { BodyComponent } from './components/body/body.component';
import { MovieComponent } from './components/movie/movie.component';
import {AdminPanelComponent} from './components/admin-panel/admin-panel.component';
import { AdminAddMovieComponent } from './components/admin-add-movie/admin-add-movie.component';
import { AdminViewProfileComponent } from './components/admin-view-profile/admin-view-profile.component';
import { OrderdetailsComponent } from './components/orderdetails/orderdetails.component';
import { OrderreceiptComponent } from './components/orderreceipt/orderreceipt.component';

const appRoutes : Routes = [

{

path : 'login' ,
component : LoginComponent


},


{

  path : 'signup' ,
  component : SignupComponent
  
  
  },

  {
  path : 'profile' ,
  component : ProfileComponent
  
  
  },

  {
  path : 'request-password-reset' ,
  component : RequestResetComponent
  
  
  },

  {
    path : 'response-password-reset' ,
    component : ResponseResetComponent
    
    
    },

    {


      
    path : 'booking' ,
    component : BookingComponent

    },

    {
     path : 'home',
     component : BodyComponent


    },

    {
     path : 'movie' ,
     component : MovieComponent

    },

    {
      path : 'admin',
      component : AdminPanelComponent
    },

    {
      path : 'admin/deleteMovie',
      component : AdminAddMovieComponent

    },

    {
      path : 'admin/viewProfiles',
      component : AdminViewProfileComponent


    },

    {
      path : 'orderdetails',
      component : OrderdetailsComponent

    },

    {
      path : 'orderreceipt',
      component : OrderreceiptComponent

    }


];


@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  
exports : [RouterModule]

})


export class AppRoutingModule { }
