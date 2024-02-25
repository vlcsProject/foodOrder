import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { ApiService } from 'src/api.service';
import { SnackbarService } from 'src/app/snackbar.service';

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})
export class FoodsComponent implements OnInit {
  category: String;
  veg: any;
  userId: any;

  constructor(private api: ApiService, private route: Router, private snackbar: SnackbarService,private routes: ActivatedRoute) {
    this.category = this.routes.snapshot.queryParams['id'];

  }
  nonveg: any[] = [];

  ngOnInit() {
    this.gets();

    let data = localStorage.getItem("res");

    if (data) {
      console.log(JSON.parse(data));
      let item = JSON.parse(data);
      this.userId = item.id;
    }


  }


  getImage(image: String): String {
    console.log("getImage called with image:", image);
    return `http://localhost:8080/products/getProductImage/${image}`;
}


  gets() {
    this.api.get('/products/getByCategory/' + this.category).subscribe((res) => {
      console.log("success");

      this.nonveg = res;
      this.veg = res;
      console.log(this.nonveg);

    })
  }
  post(data: any) {

    if(this.userId){

  
    console.log(data);
    let payload: any = {};
    payload['productName'] = data.productName;
    payload['quantity'] = data.quantity;
    payload['price'] = data.price;
    payload['image'] = data.image;
    payload['user'] = {
      "id": this.userId
    };
    payload['productId'] = data.id;



    this.api.post("/cart", payload).subscribe((res) => {
      this.snackbar.showSuccessMessage(res.message);


    });
  }else{
    this.route.navigate(['login'])
  }
  }
}
