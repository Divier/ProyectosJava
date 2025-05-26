import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Product } from '../../models/product';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {

  @Output() emitProductOut = new EventEmitter();

  @Input() product: Product = {
    id: 0,
    name: '',
    description: '',
    price: 0
  };

  onSubmit(): void {
    console.log(this.product);
    this.emitProductOut.emit(this.product);
  }

  clean(): void {
    this.product = new Product();
  }
}
