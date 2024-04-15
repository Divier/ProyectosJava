/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.builder.variante2;

/**
 *
 * @author hsrx4
 */
public class Principal {
    
    public static void main(String[] args) {
        Task task = new Task.TaskBuilder(5L).setDescription("Hello").setSummary("Test").build();
        System.out.println(task);
    }
}
