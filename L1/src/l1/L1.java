package l1;


import java.lang.Math;
import java.util.Scanner;


public class L1 {
    public static void main(String[] args) {
        //summ();
        //sub();
        //mul();
        //div();
        //factorial();
        //hypotenuse();
        //pow();
        //System.out.println("sqrt(81) = "+sqrt(81));
        //System.out.println("Число Пи (Лейбниц): "+leibnic());
        //System.out.println("Число Пи (Валлис): "+vallis());
        //work();
        //firma(2);
        //swipeMaxMin();
        //bubbleSort();
        //average();
        //evenOdd();
        //randomTable();
        //concat();
    }
    
    public static void summ() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("First num: ");
        int i = in.nextInt();
        
        System.out.println("Second num: ");
        int j = in.nextInt();
        
        System.out.println("Summ: "+(i+j));
    }
    
    public static void sub(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("First num: ");
        int i = in.nextInt();
        
        System.out.println("Second num: ");
        int j = in.nextInt();
        
        System.out.println("Sub: "+(i-j));
    }
    
    public static void mul() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("First num: ");
        int i = in.nextInt();
        
        System.out.println("Second num: ");
        int j = in.nextInt();
        
        System.out.println("Mul: "+(i*j));
    }
    
    public static void div(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("First num: ");
        int i = in.nextInt();
        
        System.out.println("Second num: ");
        int j = in.nextInt();
        
        System.out.println("Div: "+(i/j));
    }
    
    public static void factorial() {
        Scanner in = new Scanner(System.in);
        System.out.println("Factorial number: ");
        int factor = in.nextInt();
        if(factor>10) {
            System.out.println("Factorial is more than 10!");
            return;
        }
        int result = 1;
        while(factor!=1){
            result*=factor;
            factor--;
        }
        System.out.println("Factorial "+factor+" = "+result);
    }

    public static void hypotenuse() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Side A: ");
        int a = in.nextInt();
        System.out.println("Side B: ");
        int b = in.nextInt();
        System.out.println("Side C: "+Math.sqrt(Math.pow(a, 2) + Math.pow(b,2)));
        
    }

    public static void pow() {
        Scanner in = new Scanner(System.in);
        System.out.println("Degree of 2: ");
        int degree = in.nextInt();
        int result = 1;
        for(int i=1; i<=degree; i++){
            result*=2;
        }
        System.out.println("2^"+degree+" = "+result);
    }
    
    public static double sqrt(){
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        double b = a;
        int i=0;
        while ((b*b>a)&&(i<200)){
            b=(b+a/b)/2;
            i++;
        }
        return b;
    }
    
    public static double leibnic(){
        double pi = 0;
        for(double i=1;i<10000000;i+=1){
            if (i%2==0){
                pi-=1/(2*i-1);
            }else{
                pi+=1/(2*i-1);
            }
        }
        pi*=4;
        return pi;
    }
    
    public static double vallis(){
        double pi;
        double pi1=1, pi2=1;
        for(double i=2;i<10000000;i+=2){
            pi1*=i/(i+1);
            pi2*=i/(i-1);
        }
        pi=pi1*pi2*2;
        return pi;
    }
    
    public static void work(){
        long x=0;
        for(int i=1;i<10;i++){
            for (int j=0;j<10;j++){
                for (int k=0;k<10;k++){
                    x=i*100+j*10+k;
                    if (x==(Math.pow(i,3)+Math.pow(j, 3) + Math.pow(k,3))){
                        System.out.println(i+"^3+"+j+"^3+"+k+"^3+"+" = "+x);
                    }
                }
            }
        }
    }
    
    public static void firma(int degree){
        for(int i=1; i<=100; i++){
            for(int j=1;j<=100;j++){
                for(int k=1;k<=100;k++){
                    if(Math.pow(i, degree)+Math.pow(j, degree) == Math.pow(k, degree)) {
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
        
    }
    
    public static void swipeMaxMin(){
        int d_max = 50;
        short[] array = new short[25];
        
        for(int i=0; i<array.length; i++) {
            array[i] = (short)(Math.random()*d_max);
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        
        int min = 0;
        int max = 0;
        
        for(int i=1; i<array.length; i++) {
            if(array[min] > array[i]) {
                min = i;
            }
            if(array[max] < array[i]){
                max = i;
            }
        }
        
        short tmp = array[max];
        array[max] = array[min];
        array[min] = tmp;
        
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    
    public static void bubbleSort(){
        int size = (int)(Math.random()*1000);
        short[] array = new short[size];
        
        for(int i=0; i<array.length; i++) {
            array[i] = (short)(Math.random()*100);
        }

        short tmp = 0;
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[i] < array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        
        for(int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
    
    public static void average(){
        int size = 5;
        short[] array = new short[size];
        
        for(int i=0; i<array.length; i++) {
            array[i] = (short)(Math.random()*100);
            System.out.print(array[i]+" ");
        }
        System.out.println("");
        
        int value = 0;
        for(int i=0; i<array.length; i++) {
            value+=array[i];
        }
        System.out.println("Average value: "+((double)value/(double)size));
    }
    
    public static void evenOdd(){
        int even = 0;
        int odd = 0;
        
        int size = 10;
        short[] array = new short[size];
        
        for(int i=0; i<array.length; i++) {
            array[i] = (short)(Math.random()*100);
            System.out.print(array[i]+" ");
            if(array[i]%2==0){
                even+=array[i];
            } else {
                odd+=array[i];
            }
        }
        System.out.println("");
        System.out.println("Even: "+even+" Odd: "+odd);
    }
    
    public static void randomTable(){
        for(int i=0; i<3; i++){
            for(int j=0; j<5;j++){
                System.out.print((short)(Math.random()*10)+" ");
            }
            System.out.println("");
        }
    }
    
    public static void concat(){
        String s1, s2, s3, s4, s5;
        Scanner in = new Scanner(System.in);
        
        System.out.println("Input string 1: ");
        s1 = in.nextLine();
        System.out.println("Input string 2: ");
        s2 = in.nextLine();
        System.out.println("Input string 3: ");
        s3 = in.nextLine();
        System.out.println("Input string 4: ");
        s4 = in.nextLine();
        System.out.println("Input string 5: ");
        s5 = in.nextLine();
        
        if(s4.equals(s5)) {
            System.out.println(s1+s2);
        } else {
            System.out.println(s1+s3);
        }
    }
}
