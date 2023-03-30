import { Component, OnInit} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../service/productService';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  productData:Product ={};
  
  constructor(private productService: ProductService, private router: Router, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.productData=this.productService.dataToUpdate;
    console.log(this.productData);
  }

  updateProduct()
  {
    this.productService.updateProduct(this.productData.id,this.productData).subscribe({
      next:(data)=>{
        alert("Product updated succesfully");
        this.router.navigate(['']);
      },
      error:(error)=>{
        alert("error occured");
      }
    });
  }

}
