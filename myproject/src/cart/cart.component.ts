import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/api.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  userById:any;
addItems:any[]=[];


  constructor( private api:ApiService) { }

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
    console.log("getImage called with image:", image);
    return `http://localhost:8080/products/getProductImage/${image}`;
}

  delete(item:any){
    this.api.delete('/cart/delete/'+item.id).subscribe((res)=>{
      console.log(item);
      this.getall();
    })
  }
}
