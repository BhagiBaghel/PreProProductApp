import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/product';

@Injectable({
    providedIn:'root'
})
export class ProductService {
    
    dataToUpdate:Product={};

    constructor(private httpClient:HttpClient){}

    addProduct(product?:Product)

    {
        return this.httpClient.post<Product>('http://localhost:8080/api/v1/product',product);
    }

    getAllProducts()
    {
        return this.httpClient.get<Array<Product>>('http://localhost:8080/api/v1/products');
    }

    updateProduct(id:any, product:Product)
    {
        return this.httpClient.put<Product>('http://localhost:8080/api/v1/update/'+id, product);
    }

    getProductById(id:any)
    {
        return this.httpClient.get<Product>('http://localhost:8080/api/v1/product/'+id);
    }

    deleteProduct(id:number)
    {
        return this.httpClient.delete<Array<Product>>('http://localhost:8080/api/v1/delete/'+id);
    }

}