import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../models/product';
import { FormComponent } from "./form/form.component";

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [FormComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit {

  public products: Product[] = [];
  public productSelected: Product = new Product();

  constructor(private service: ProductService) {

  }

  ngOnInit(): void {
    this.service.findAll().subscribe(products => this.products = products);
  }

  emitProductIn(product: Product) {
    if (product.id > 0) {
      this.products = this.products.map((productMap) => {
        if (product.id == productMap.id) {
          return { ...product };
        }
        return productMap;
      })
    } else {
      //this.products.push(product);//Muta el array
      this.products = [...this.products, { ...product, id: Math.floor(Math.random() * 1000) }];//Inmutable
    }
    this.productSelected = new Product();
  }

  onUpdate(product: Product) {
    //this.productSelected = product//Mutable, se mantiene la misma instancia para que el product se cambie al tiempo en la tabla;
    this.productSelected = { ...product }//Inmutable, crea una nueva instancia para que el product no se cambie al tiempo en la tabla;
  }

  onDelete(id: number) {
    this.products = this.products.filter(productMap => productMap.id != id)
  }
}
