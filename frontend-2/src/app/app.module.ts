import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { ProfileComponent } from './components/profile/profile.component';
import { PasswordComponent } from './components/password/password.component';
import { RequestResetComponent } from './components/password/request-reset/request-reset.component';
import { ResponseResetComponent } from './components/password/response-reset/response-reset.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';

import { from } from 'rxjs';
import { BodyComponent } from './components/body/body.component';
import { BookingComponent } from './components/booking/booking.component';
import { MovieComponent } from './components/movie/movie.component';
import { AdminPanelComponent } from './components/admin-panel/admin-panel.component';
import { AdminAddMovieComponent } from './components/admin-add-movie/admin-add-movie.component';
import { AdminViewProfileComponent } from './components/admin-view-profile/admin-view-profile.component';
import { OrderdetailsComponent } from './components/orderdetails/orderdetails.component';
import { OrderreceiptComponent } from './components/orderreceipt/orderreceipt.component';


@NgModule({


  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent,
    ProfileComponent,
    PasswordComponent,
    RequestResetComponent,
    ResponseResetComponent,
    BodyComponent,
    BookingComponent,
    MovieComponent,
    AdminPanelComponent,
    AdminAddMovieComponent,
    AdminViewProfileComponent,
    OrderdetailsComponent,
    OrderreceiptComponent
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
   
    
  ],
  
  providers: [],
  bootstrap: [AppComponent]
}) 

export class AppModule { }
