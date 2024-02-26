import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BuyComponent } from 'src/buy/buy.component';
import { CartComponent } from 'src/cart/cart.component';
import { FoodsComponent } from 'src/foods/foods.component';
import { HeaderComponent } from 'src/header/header.component';
import { HomeComponent } from 'src/home/home.component';
import { LoginComponent } from 'src/login/login.component';
import { SignupComponent } from 'src/signup/signup.component';

const routes: Routes = [


  {path:"food",component:FoodsComponent},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"login",component:HeaderComponent} ,
  {path:"",component:HomeComponent} ,
  {path:"cart",component:CartComponent},
  {path:'buy',component:BuyComponent},
  {path:'cart',component:CartComponent},








  




];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
