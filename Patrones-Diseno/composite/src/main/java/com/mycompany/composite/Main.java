/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.composite;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author hsrx4
 */
public class Main {

    public static void main(String[] args) {
        SimpleProductLeaf ram4gb = new SimpleProductLeaf("Memoria RAM 4GB", 750, "KingStone");
        SimpleProductLeaf ram8gb = new SimpleProductLeaf("Memoria RAM 8GB", 1000, "KingStone");

        SimpleProductLeaf disk500gb = new SimpleProductLeaf("Disco Duro 500GB", 1500, "ACME");
        SimpleProductLeaf disk1tb = new SimpleProductLeaf("Disco Duro 1TB", 2000, "ACME");

        SimpleProductLeaf cpuAMD = new SimpleProductLeaf("AMD phenon", 4000, "AMD");
        SimpleProductLeaf cpuIntel = new SimpleProductLeaf("Intel i7", 4500, "Intel");

        SimpleProductLeaf smallCabinete = new SimpleProductLeaf("Gabinete Pequeño", 2000, "ExCom");
        SimpleProductLeaf bigCabinete = new SimpleProductLeaf("Gabinete Grande", 2200, "ExCom");

        SimpleProductLeaf monitor20inch = new SimpleProductLeaf("Monitor 20'", 1500, "HP");
        SimpleProductLeaf monitor30inch = new SimpleProductLeaf("Monitor 30'", 2000, "HP");

        SimpleProductLeaf simpleMouse = new SimpleProductLeaf("Raton Simple", 150, "Genius");
        SimpleProductLeaf gammerMouse = new SimpleProductLeaf("Raton Gammer", 750, "Alien");

//Computadora para Gammer que incluye 8gb de ram,disco de 1tb, procesador Intel i7
//gabinete grande,monitor de 30' y un mouse gammer.
        ProductComposite gammerPC = new ProductComposite("Gammer PC");
        gammerPC.addProduct(ram8gb);
        gammerPC.addProduct(disk1tb);
        gammerPC.addProduct(cpuIntel);
        gammerPC.addProduct(bigCabinete);
        gammerPC.addProduct(monitor30inch);
        gammerPC.addProduct(gammerMouse);

//Computadora para Casa que incluye 4gb de ram,disco de 500gb, procesador AMD Phenon
//gabinete chico,monitor de 20' y un mouse simple.
        ProductComposite homePC = new ProductComposite("Casa PC");
        homePC.addProduct(ram4gb);
        homePC.addProduct(disk500gb);
        homePC.addProduct(cpuAMD);
        homePC.addProduct(smallCabinete);
        homePC.addProduct(monitor20inch);
        homePC.addProduct(simpleMouse);

//Paque compuesto de dos paquetes, El paquete Gammer PC y Home PC
        ProductComposite pc2x1 = new ProductComposite("Paquete PC Gammer + Casa");
        pc2x1.addProduct(gammerPC);
        pc2x1.addProduct(homePC);
        

        OrdenVenta gammerOrder = new OrdenVenta(1, "Juan Perez");
        gammerOrder.addProduct(gammerPC);
        gammerOrder.printOrder();

        OrdenVenta homeOrder = new OrdenVenta(2, "Marcos Guerra");
        homeOrder.addProduct(homePC);
        homeOrder.printOrder();

        OrdenVenta comboOrder = new OrdenVenta(3, "Paquete 2x1 en PC");
        comboOrder.addProduct(pc2x1);
        comboOrder.printOrder();

        OrdenVenta customOrder = new OrdenVenta(4, "Oscar Blancarte");
        customOrder.addProduct(homePC);
        customOrder.addProduct(ram8gb);
        customOrder.addProduct(ram4gb);
        customOrder.addProduct(monitor30inch);
        customOrder.addProduct(gammerMouse);
        customOrder.printOrder();
    }
}
