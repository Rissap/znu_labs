package l6;

public class ObjectTree {
    private static int IDnum=8; // Количество цифр в ID-коде объектакоде объекта
    
    public int value;
    
    private char Level; // Уровень объекта обозначенный буквой
    private int Number; // Номер объекта на определенном уровне
    private int[] ID; // Массив, который содержит ID-коде объектакод объекта

    ObjectTree FirstRef; // Левый сын
    ObjectTree SecondRef; // Правый сын
    
    ObjectTree(int k,char L,int n){ 
        // Конструктор бинарного дерева: 
        // k — количество уровней дерева, L — буквенное
        // обозначение уровня, n — номер узла на уровне
        //System.out.println("\tСоздан новый объект!");
        Level=L;
        Number=n;
        getID();
        show();
        if(k==1){
            FirstRef=null;
            SecondRef=null;
        }else{
            // Рекурсивный вызов конструктора для левого и правого сына
            FirstRef = new ObjectTree(k-1,(char)((int)L+1),2*n-1);
            SecondRef = new ObjectTree(k-1,(char)((int)L+1),2*n);}
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

    void show(){ // Метод для отображения положения узла
        System.out.println("Уровень объекта: \t"+Level);
        System.out.println("Номер на уровне: \t"+Number);
        System.out.print("ID-код объекта: \t");
        showID();
    }

    
    
    
}