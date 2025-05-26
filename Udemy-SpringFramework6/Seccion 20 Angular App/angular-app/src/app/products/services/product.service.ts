import { Injectable } from '@angular/core';
import { Product } from '../models/product';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private products: Product[] = [
    {
      id: 1,
      name: 'Sala',
      description: 'Sala Grande',
      price: 200
    },
    {
      id: 2,
      name: 'Cama',
      description: 'Pequeña',
      price: 100
    }
  ];
  constructor() {

  }

  findAll(): Observable<Product[]> {
    return of(this.products);
  }
}
