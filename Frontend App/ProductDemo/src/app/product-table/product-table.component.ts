import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { Product } from '../model/product';
import { ProductService } from '../service/productService';

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrls: ['./product-table.component.css']
})
export class ProductTableComponent implements OnInit{

  imgUrl = "../../assets/apple.jpg";

  totalPrice():number {
  let total = 0;
  for(let products of this.productDetails)
  {
    total +=  products.price * products.quantity;
  }
  return total;
  }

  productDetails:Product[]=[];

  constructor( private router:Router, private productService:ProductService ){}

ngOnInit(): void {
  this.productService.getAllProducts().subscribe({next:(data)=>{
    console.log(data);
    this.productDetails = data;
  },
  error:(error)=>{
    alert('Error found');
  }
 });
}
  

deleteProduct(id:any)
{
  this.productService.deleteProduct(id).subscribe({
    next:(data)=>{
      alert('Product deleted');
      this.productDetails = data;
    },
    error:(error)=>{
      alert('Product not deleted')
    }
  });
}

updateProduct(product:Product)
{
  console.log(product);
  this.productService.dataToUpdate=product;
  console.log(this.productService.dataToUpdate);
  this.router.navigate(['update'])
}


}
