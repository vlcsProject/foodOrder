import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HeaderComponent } from 'src/header/header.component';

const routes: Routes = [
  {path:"",component:AdminComponent},
  {path:"login",component:HeaderComponent} 

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HeadRoutingModule { }
