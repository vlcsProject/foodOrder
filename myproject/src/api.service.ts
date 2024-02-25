import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Signupentity } from './signup/signupentity';

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  constructor(private http:HttpClient) { }

  baseurl="http://localhost:8080";
  
  
  
  post(path:any,data:any):Observable<any>{
    return this.http.post(this.baseurl+path,data)
  }
  get(path:any):Observable<any>{
    return this.http.get(this.baseurl+path);
  }
  delete(path:any):Observable<any>{
    return this.http.delete(this.baseurl+path);
  }
  put(path:any,data:any):Observable<any>{
    return this.http.put(this.baseurl+path,data)
  }
  sigPpost(data:any):Observable<Signupentity>{
    return this.http.post<Signupentity>(this.baseurl+'/user/save',data)
  }
  }
  