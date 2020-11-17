/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l5;

import java.util.Scanner;

/**
 *
 * @author Riisa
 */
public class L5 {

    public static void main(String[] args) {
        //stringFoo();
        System.out.println("String sort:");
        stringSort("ababagalamaga");
        System.out.println("StringBuffer sort:");
        stringSort(new StringBuffer("ababagalamaga"));
        System.out.println("StringBuilder sort:");
        stringSort(new StringBuilder("ababagalamaga"));
    }
    
    public static void stringFoo(){
        long t1,t2;
        int numsimb;
        Scanner sc = new Scanner(System.in);
        System.out.print("Какая должна быть длина последовательности? - ");
        numsimb=sc.nextInt();
 
        // Используем простой String
        String Key="";
        //System.out.println(" Key = "+Key);
        t1=System.currentTimeMillis();
        for(int i=0; i<numsimb; i++) {
            Key+=(char)((int)( Math.random() *255 ));
        }
        t2 = System.currentTimeMillis();
        //System.out.println(" Key = "+Key);
        System.out.println("Время вычисления = "+(double)(t2-t1)/1000+" s");
        System.out.println("Длина строки = "+Key.length());
 
        // Используем StringBuilder
        StringBuilder Key2=new StringBuilder("");
        //System.out.println(" Key = "+Key2);
        t1=System.currentTimeMillis();
        for(int i=0; i<numsimb; i++) {
            Key2.append( (char)( (int)(Math.random()*255)) );
        }
 
        t2=System.currentTimeMillis();
        //System.out.println(" Key = "+Key2.toString());
        System.out.println("Время вычисления = "+(double)(t2-t1)/1000+" s");
        System.out.println("Длина строки = "+Key2.length());
 
        // Используем StringBuffer
        StringBuffer Key3=new StringBuffer("");
        //System.out.println(" Key = "+Key3);
        t1 = System.currentTimeMillis();
        for(int i=0; i<numsimb; i++) {
            Key3.append((char)((int)(Math.random()*255)));
        }
 
        t2=System.currentTimeMillis();
        //System.out.println(" Key = "+Key3.toString());
        System.out.println("Время вычисления = "+(double)(t2-t1)/1000+" s");
        System.out.println("Длина строки = "+Key3.length());
    }

    
    public static void stringSort(String str){
        char[] strBuffer = str.toCharArray();
        
        char tmp = 0;
        for(int i=0; i<strBuffer.length; i++){
            for(int j=0; j<strBuffer.length; j++){
                if((int)strBuffer[i] < strBuffer[j]){
                    tmp = strBuffer[j];
                    strBuffer[j] = strBuffer[i];
                    strBuffer[i] = tmp;
                }
                    
            }
        }
        
        for(int i=0;i<str.length(); i++){
            System.out.print(strBuffer[i]);
        }
        System.out.println("");
    }
    
    public static void stringSort(StringBuffer str){
        char tmp = 0;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                if((int)str.charAt(i) < (int)str.charAt(j)){
                    tmp = str.charAt(j);
                    str.setCharAt(j, str.charAt(i));
                    str.setCharAt(i, tmp);
                }
                    
            }
        }
        
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i));
        }
        System.out.println("");
    }
    
    public static void stringSort(StringBuilder str){
        char tmp = 0;
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                if((int)str.charAt(i) < (int)str.charAt(j)){
                    tmp = str.charAt(j);
                    str.setCharAt(j, str.charAt(i));
                    str.setCharAt(i, tmp);
                }
                    
            }
        }
        
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i));
        }
        System.out.println("");
    }
}
