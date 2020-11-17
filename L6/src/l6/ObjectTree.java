package l6;
import java.lang.Math;

public class ObjectTree {
    public static int IDnum=8; // Количество цифр в ID-коде объектакоде объекта
    
    public int value = 0;
    
    public char Level; // Уровень объекта обозначенный буквой
    public int Number; // Номер объекта на определенном уровне
    public int[] ID; // Массив, который содержит ID-коде объектакод объекта

    ObjectTree FirstRef; // Левый сын
    ObjectTree SecondRef; // Правый сын
    
    ObjectTree(int k,char L,int n){ 
        // Конструктор бинарного дерева: 
        // k — количество уровней дерева, L — буквенное
        // обозначение уровня, n — номер узла на уровне
        //System.out.println("\tСоздан новый объект!");
        Level=L;
        Number=n;
        //Number = (int)(5+Math.random()*10);
        getID();
        if(k==1){
            FirstRef=null;
            SecondRef=null;
        }else{
            // Рекурсивный вызов конструктора для левого и правого сына
            FirstRef = new ObjectTree(k-1,(char)((int)L+1),2*n-1);
            SecondRef = new ObjectTree(k-1,(char)((int)L+1),2*n);}
        }
    
    ObjectTree(int amount){ 
        Level='A';
        Number=1;
        getID();
        if(amount==1){
            FirstRef=null;
            SecondRef=null;
        }else{
            // Рекурсивный вызов конструктора для левого и правого сына
            FirstRef = new ObjectTree(amount-1,(char)((int)Level+1),2*1-1);
            SecondRef = new ObjectTree(amount-1,(char)((int)Level+1),2*1);}
        }
    
    
    private void getID(){ // Метод для генерации ID-коде объектакода
        ID = new int[IDnum];
        for(int i=0;i<IDnum;i++){
            ID[i]=(int)(Math.random()*10);
        }
    }
    
    private void showID(){ // Метод для отображения ID-коде объекта кода
        for(int i=0;i<IDnum;i++)
            System.out.print("|"+ID[i]);
        System.out.print("|\n");
    }

    public void show(){ // Метод для отображения положения узла
        System.out.println("Уровень объекта: \t"+Level);
        System.out.println("Номер на уровне: \t"+Number);
        System.out.print("ID-код объекта: \t");
        showID();
        System.out.println("Значение объекта: \t" + value);
        if(FirstRef!=null)
            FirstRef.show();
        if(SecondRef != null)
            SecondRef.show();
    }

    public boolean isFullTree(){
        if(FirstRef == null && SecondRef == null) {
            return true;
        }
        else {
            if(FirstRef!= null && SecondRef!= null) {
                return FirstRef.isFullTree() && SecondRef.isFullTree();
            }
            return false;
        }

    }
    
    public int hasEmptySpace(char level, int number){
        if(level==Level){
            if(number-1 == Number && FirstRef == null || SecondRef == null){
                return 1;
            } else {
                return -1;
            }
        } else {
            int a, b;
            a = FirstRef.hasEmptySpace(level, number);
            b = SecondRef.hasEmptySpace(level, number);
            if( a == 1 || b == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
    public void putElement(int elem, char level, int number) {
        if(level == Level){
            if(number == Number){
                value = elem;
            }
        } else {
           FirstRef.putElement(elem, level, number);
           SecondRef.putElement(elem, level, number);
        }
    }
    
    public void delElement(char level, int number) {
        if(FirstRef != null && FirstRef.Level == level && FirstRef.Number == number){
            FirstRef = null;
        }
        if(SecondRef != null && SecondRef.Level == level && SecondRef.Number == number){
            SecondRef = null;
        }
    }
    
    public void fixBroken() {
        if (FirstRef != null && SecondRef == null) {
            FirstRef = null;
        } else if(FirstRef == null && SecondRef != null) {
            SecondRef = null;
        } else { 
         FirstRef.fixBroken();
         SecondRef.fixBroken();
        }
    }
    
}