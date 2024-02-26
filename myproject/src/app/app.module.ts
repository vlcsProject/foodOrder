import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from 'src/header/header.component';
import { FoodsComponent } from 'src/foods/foods.component';
import { LoginComponent } from 'src/login/login.component';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar'; 
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignupComponent } from 'src/signup/signup.component';
import { HomeComponent } from 'src/home/home.component';
import { CartComponent } from 'src/cart/cart.component';

@NgModule({
  declarations: [							
    AppComponent,
      HeaderComponent,
      FoodsComponent,
      LoginComponent,
      SignupComponent,
      HomeComponent,
      CartComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    FormsModule,ReactiveFormsModule,
    MatSnackBarModule,
    BrowserAnimationsModule

   

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }