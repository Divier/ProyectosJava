/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.builder.variante1;

/**
 *
 * @author hsrx4
 */
public class Principal {

    public static void main(String[] args) {
        Cocina cocina = new Cocina(); // Director.
        PizzaBuilder hawai_pizzabuilder = new HawaiPizzaBuilder();
        PizzaBuilder picante_pizzabuilder = new PicantePizzaBuilder();
 
        cocina.setPizzaBuilder( hawai_pizzabuilder );
        cocina.construirPizza();
        System.out.println(cocina.getPizza());
        
        cocina.setPizzaBuilder( picante_pizzabuilder );
        cocina.construirPizza();
        System.out.println(cocina.getPizza());
    }
}
