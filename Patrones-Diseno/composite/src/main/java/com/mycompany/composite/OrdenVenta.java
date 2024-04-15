/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.composite;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author hsrx4
 */
public class OrdenVenta {
    
    private long orderId;
    private String customer;
    private Calendar dateTime;
    private List<AbstractProductComponent> products = new ArrayList<>();

    public OrdenVenta(long orderId, String customer) {
        super();
        this.orderId = orderId;
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(Calendar dateTime) {
        this.dateTime = dateTime;
    }

    public List getProducts() {
        return products;
    }

    public void setProducts(List products) {
        this.products = products;
    }

    public double getPrice() {
        double price = 0d;
        for (AbstractProductComponent child : products) {
            price += child.getPrice();
        }
        return price;
    }

    public void addProduct(AbstractProductComponent product) {
        products.add(product);
    }

    public void removeProduct(AbstractProductComponent product) {
        products.remove(product);
    }

    public void printOrder() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("=============================================Orden: " + orderId + " Cliente: " + customer + "Productos:");
        for (AbstractProductComponent prod : products) {
            System.out.println(prod.getName() + " $" + formater.format(prod.getPrice()));
        }
        System.out.println("Total: " + formater.format(getPrice()) + "=============================================");
    }
}
