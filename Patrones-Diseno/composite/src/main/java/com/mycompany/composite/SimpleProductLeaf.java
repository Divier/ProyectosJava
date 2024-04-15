package com.mycompany.composite;

/**
 *
 * @author hsrx4
 */
public class SimpleProductLeaf extends AbstractProductComponent {

    protected String brand;

    public SimpleProductLeaf(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}