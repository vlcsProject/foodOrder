import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/api.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  userById:any;
  addItems:any[]=[];
  cartItems: any[]=[];


  constructor( private api:ApiService ,private route:Router) { }

  ngOnInit() {
    this.getall();
  }
  getall(){
    let data = localStorage.getItem("res");
    if (data) {
      console.log(JSON.parse(data));
      let item = JSON.parse(data);
      this.userById = item.id;

    }    this.api.get('/cart/userById/'+this.userById).subscribe((res)=>{
      console.log(res);
      this.addItems=res;
      
      
  
    })
  }
  getImage(image: String): String {

    return `http://localhost:8080/${image}`;

  }
  delete(item:any){
    this.api.delete('/cart/delete/'+item.id).subscribe((res)=>{
      console.log(item);
      this.getall();
    })
  }


buy(id:any){
  this.route.navigate(['buy'],{queryParams:{id:id}}
  )
}
}
