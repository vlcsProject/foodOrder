import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from 'src/api.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  id: any;
  data: any;
  
 
  buy: any;
  userId: any;
  cartItems: any;
  inputValue: number = 1;
  total: any;
  addItems: any;
  
  


  
  
  constructor(private route: Router, private routes: ActivatedRoute, private api: ApiService) {
    this.id = this.routes.snapshot.queryParams['id'];
  }

  ngOnInit() {
    this.api.get('/products/getById/' + this.id).subscribe((res: any) => {
        this.data = res;
     
    });
  }

  
  getImage(image: String): String {
    
    return `http://localhost:8080/products/getProductImage/${image}`;
}
cart(){
  this.route.navigate(['cart'])
  
}

totalPrice(item: any): number {
  return item.price * item.price; 
}
getGrandTotal(): number {
  let grandTotal = 0;

  for (let item of this.addItems) {
    grandTotal += this.totalPrice(item);
  }

  return grandTotal;
}

calculateTotal(): void {
  
}


}
