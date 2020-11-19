/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19simagingreengrocer;

import entity.Customer;
import entity.Pourchase;
import entity.Product;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import tools.managers.PersonManager;
import tools.managers.ProductManager;
import tools.savers.SaveToFile;

/**
 *
 * @author user
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    
    private  List<Product> listProducts = new ArrayList<>();
    private  List<Customer> listCustomers = new ArrayList<>();
    private  List<Pourchase> listPourchase = new ArrayList<>();
    
    private ProductManager productManager = new ProductManager();
    private PersonManager personManager = new PersonManager();
    private Product product;
    
    public App() {
        SaveToFile saveToFile = new SaveToFile();
        this.listCustomers = saveToFile.loadFromFile("listPersons");
        this.listProducts = saveToFile.loadFromFile("listProduct"); 
        this.listPourchase = saveToFile.loadFromFile("listPourchase");
    }
    
    public void run() {
        System.out.println("---- Продуктовый магазин ----");
        boolean repeat = true;
        do {
            System.out.println("Здравствуйе! Что вам нужно?");
            System.out.println("0. Выйти ");
            System.out.println("1. Добавить товар ");
            System.out.println("2. Cписок наших товаров");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Купить товар");
            System.out.print("Выберите задачу: ");           
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("---- Выход ----");
                    repeat = false;
                    break; 
            //----------------------------------------------------------------//        
                case "1":
                    System.out.println("---- Добавить товар ----");
                    Product product = productManager.createProduct();            
                    productManager.addProductToList(product, listProducts);
                    break;
            //----------------------------------------------------------------//      
                case "2":
                    System.out.println("---- Список наших товаров ----");
                    productManager.printListProduct(listProducts);
                    break;
            //----------------------------------------------------------------//
                case "3":
                    System.out.println("---- Добавить покупателя ----");
                    Customer customer = personManager.createCustomer(); 
                    personManager.addPersonToList(customer, listCustomers);
                    break;
            //----------------------------------------------------------------//
                case "4":
                    System.out.println("---- Список покупателей ----");
                    personManager.printListProduct(listCustomers);
                    break;
            //----------------------------------------------------------------//       
                case "5":
                    System.out.println("---- Купить товар ----");
                    productManager.printListProduct(listProducts);
                    System.out.print("Выберите товар: ");
                    int chooseProduct = scanner.nextInt();
                    personManager.printListProduct(listCustomers);
                    System.out.print("Выберите покупателя: ");
                    int chooseCustomer = scanner.nextInt();
                    product = listProducts.get(chooseProduct - 1);
                    System.out.print(product.getName());
                    customer = listCustomers.get(chooseCustomer - 1);
                    if(customer.getMoney() >= product.getPrice()) {
                        customer.setMoney(customer.getMoney() - product.getPrice());
                        Pourchase pourchase = new Pourchase();
                        pourchase.setProduct(listProducts.get(chooseProduct - 1));
                        pourchase.setCustomer(listCustomers.get(chooseCustomer - 1));
                        GregorianCalendar c = new GregorianCalendar();
                        pourchase.setDate(c.getTime());
                        listPourchase.add(pourchase);
                        listProducts.remove(chooseProduct - 1);
                        SaveToFile saveToFile = new SaveToFile();
                        saveToFile.saveToFile(listProducts, "listProduct");
                        saveToFile.saveToFile(listCustomers, "listPersons");                       
                    } else {
                        System.out.print("У вас не хватает денег!");
                    }            
                    break;
            //----------------------------------------------------------------//
                default:
                    System.out.println("Нет такой задачи. Повторите попытку!");

            //----------------------------------------------------------------//        
            }        
        }while(repeat); 
    }  
    
}
