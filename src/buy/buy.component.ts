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
  
  calculateTotal(event: any): void {
    const inputValue:any = (event.target as HTMLInputElement).value;
    console.log(inputValue);
      this.total = inputValue * this.data.price ;
  }
  


  
  gotocheckout() {
  if(this.cartItems.length > 0){
 
  this.buy = true;
  }}

  constructor(private route: Router, private routes: ActivatedRoute, private api: ApiService) {
    this.id = this.routes.snapshot.queryParams['id'];
  }

  ngOnInit() {
    this.api.get('/products/getById/' + this.id).subscribe((res: any) => {
        this.data = res;
     
    });
  }

  getImage(image: string): string {
    return `http://localhost:8080/${image}`;
  }
cart(){
  this.route.navigate(['cart'])





  
}

}
