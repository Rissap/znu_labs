/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l6;

/**
 *
 * @author Riisa
 */
public class L6 {

    public static void main(String[] args) {
        ObjectTree tree = new ObjectTree(3, 'A', 1); // Создание дерева
        
        System.out.println("Проверка целостности: " + tree.isFullTree());
        
        System.out.println("Проверка возможности вставки в узел: " + tree.hasEmptySpace("A".charAt(0), 1));
        
        System.out.println("Добавление элемента в узел [350] ");
        tree.putElement(350, "B".charAt(0), 2);
        tree.show();
        
        System.out.println("Удаление элемента из узла [350]");
        
        tree.delElement("B".charAt(0), 2);
        tree.show();
        
        System.out.println("Проверка целостности: " + tree.isFullTree());
        
        System.out.println("Восстановление целостности... ");
        tree.fixBroken();
        System.out.println("Проверка целостности: " + tree.isFullTree());
        
        System.out.println("Конструктор по количеству узлов [2] ...");
        ObjectTree new_tree = new ObjectTree(2);
        new_tree.show();
        
    }
    
}
