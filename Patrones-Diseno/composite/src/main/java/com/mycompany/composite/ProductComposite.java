package com.mycompany.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hsrx4
 */
public class ProductComposite extends AbstractProductComponent {
    
    private List<AbstractProductComponent> products = new ArrayList<>();

    public ProductComposite(String name) {
        super(name, 0);
    }

    @Override
    public double getPrice() {
        double price = 0d;
        for (AbstractProductComponent child : products) {
            price += child.getPrice();
        }
        return price;
    }

    @Override
    public void setPrice(double price) {
        throw new UnsupportedOperationException();
    }

    public void addProduct(AbstractProductComponent product) {
        this.products.add(product);
    }

    public boolean removeProduct(AbstractProductComponent product) {
        return this.products.remove(product);
    }
}
