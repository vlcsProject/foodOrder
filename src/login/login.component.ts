import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Loginentity } from './loginentity';
import { SnackbarService } from 'src/app/snackbar.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  showPassword = false;
  error:any;
  togglePasswordVisibility() {
    this.showPassword = !this.showPassword;
  }
  
  constructor( private route:Router,private api:ApiService,private snackbar: SnackbarService) {}
  loginForm = new FormGroup({
    username: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required, Validators.minLength(8)])
  })

  get userName() {
    return this.loginForm.get('username');
  }

  get passWord() {
    return this.loginForm.get('password');
  }

  ngOnInit() {
    
  }
  loginentity: Loginentity = new Loginentity()

  post() {


    this.loginentity['userName'] = this.loginForm.controls['username'].value?.toString();
    this.loginentity['password'] = this.loginForm.controls['password'].value?.toString();
    this.api.post('/user/login', this.loginentity).subscribe(
      (res) => {
        console.log(res);
        window.localStorage.setItem("res", JSON.stringify(res)); 


        if (res && res.userName ) {
          this.snackbar.showSuccessMessage('login successfully ' + res.userName );
          this.route.navigate(['']);
        }
      },
      (error: any) => {
        if (error.status === 401) {
          this.error = error.error;
          console.log(error.error);
        }
      }
    );
  }
  res(res: any) {
    throw new Error('Method not implemented.');
  }

signup(){
  this.route.navigate(['signup'])
}
 

  
}