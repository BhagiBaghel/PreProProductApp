import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router'
import { Product } from '../model/product';
import { ProductService } from '../service/productService';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {

constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute){}

  productData:Product ={};

  addProduct() 
  {
    console.log(this.productData);
    this.productService.addProduct(this.productData).subscribe();
    alert("Product added successfully.");
    this.router.navigate(['']);
  }

}
