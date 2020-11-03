/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.managers;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class ProductManager {
    private Scanner scanner = new Scanner(System.in);
    public Person createProduct(String role) {
        if("PRODUCT".equals(role)){
            System.out.println("--- Добавление товара ---");
            System.out.println(" Укажите товар: ");
            Product item = new Product (item , role);
            return product;
        }else{
        }
