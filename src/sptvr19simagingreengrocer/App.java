/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptvr19simagingreengrocer;

/**
 *
 * @author user
 */
class App {
    public void run(){
        System.out.println("--- Мой Greengroocer ---");
         boolean repeat = true;
         do{
            System.out.println("Задачи:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить товар");
            System.out.println("2. Список товаров");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Покупка товара");
            System.out.println("Выберите задачу:");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("Выход из программы");
                    repeat = false;
                    break;
                case "1":
                    Product item = productManager.createproduct("ITEM");
                    productManager.addProductToList(item, listProducts);
                    
                    break;
                case "2":
                    personManager.printListStudents(listPersons);
                    break;
                case "3":
                    Person teacher = personManager.createPerson("TEACHER");
                    personManager.addPersonToList(teacher, listPersons);
                    break;
                case "4":
                    personManager.printListTeachers(listPersons);
                    break;
                case "5":
                    Subject subject = subjectManager.createSubject(listPersons);
                    subjectManager.addSubjectToList(subject, listSubjects);
                    break;
        }
