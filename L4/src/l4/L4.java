package l4;

import java.util.Scanner;

public class L4 {
    public static void main(String[] args){
        //polynomFoo();
        linkedListFoo();
    }
    
    public static void polynomFoo() {
        // Коэффициенты для полинома:
        System.out.println("Введите 5 коэффициентов полинома: ");
        
        
        double[] coefs=new double[5];
        Scanner in = new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            coefs[i] = in.nextInt();
        }
        
        // Создание полинома:
        Polynom P=new Polynom(coefs);
        System.out.println("\tКоэффициенты исходного полинома:");
        
        // Коэффициенты полинома:
        P.show();
        System.out.println("\tЗначение полинома в точке:");

        // Значение полинома для единичного аргумента:
        P.show(1);
        System.out.println("\tВторая производная:");

        // Вычисление второй производной для полинома:
        Polynom Q=P.dif(2);
        
        // Результат вычисления производной (коэффициенты):
        Q.show();
        System.out.println("\tСумма полиномов:");
        
        // Сумма полиномов (результат):
        Q.plus(P).show();
        System.out.println("\tПроизведение полиномов:");
        
        // Произведение полиномов (результат):
        Q.prod(P).show();
    }
    
    public static void linkedListFoo() {
        LinkedList list = new LinkedList();
        
        LinkedList tmp;
        // создание на основе элемента
        for(int i=0; i<10; i++){
            tmp = new LinkedList(i);
            list.setNext(tmp);
        }
        
        //создание на основе массива
        int[] array = {10, 20, 30, 40};
        tmp = new LinkedList(array);
        //связывание
        list.setNext(tmp);
        
        //создание на основе объекта LinkedList
        tmp = new LinkedList(-3500);
        LinkedList objectTmp = new LinkedList(tmp);
        
        //пробрасывание элемента по индексу
        tmp = new LinkedList(100500);
        list.setElement(tmp, 5);
        
        list.delElement(8);
        
        LinkedList itter = list.getNext();
        do{
            System.out.println(itter.getElement());
            itter = itter.getNext();
        }while(itter != null);
        
        
        itter = objectTmp;
        do{
            System.out.println(itter.getElement());
            itter = itter.getNext();
        }while(itter != null);
    }
}

