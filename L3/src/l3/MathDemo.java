/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3;

public class MathDemo {

    // Класс с математическими функциями:
    // Интервал разложения в ряд Фурье:
    static double L=Math.PI;
    
    static double Factorial(double x){
        if(x == 1){ 
            return x;
        } else {
            return x*Factorial(x-1);
        }
    }
    
    static double Pow(double x){
        double result = 0.0;
        for (int i=0; i<100; i++){
            double a = Math.pow(-1, i)*Factorial(2*x);
            double b = (1-2*x)*Math.pow(Factorial(x), 2)*Math.pow(4, i);
            result += (a/b)*Math.pow(x, i);
        }
        return result;
    }
    
    // Экспонента:
    static double Exp(double x,int N){
        int i;
        double s=0,q=1;
        for(i=0;i<N;i++){
            s+=q;
            q*=x/(i+1);
           }
        return s+q;
    }
    
    // Синус:
    static double Sin(double x,int N){
        int i;
        double s=0,q=x;
        for(i=0;i<N;i++){
            s+=q;
            q*=(-1)*x*x/(2*i+2)/(2*i+3);
        }
        return s+q;
    }
       
    // Косинус:
    static double Cos(double x,int N){
        int i;
        double s=0,q=1;
        for(i=0;i<N;i++){
            s+=q;
            q*=(-1)*x*x/(2*i+1)/(2*i+2);
        }
        return s+q;
    }

    // Функция Бесселя:
    static double BesselJ(double x,int N){
        int i;
        double s=0,q=1;
        for(i=0;i<N;i++){
            s+=q;
            q*=(-1)*x*x/4/(i+1)/(i+1);
        }
        return s+q;
    }

    // Ряд Фурье по синусам:
    static double FourSin(double x,double[] a){
        int i,N=a.length;
        double s=0;
        for(i=0;i<N;i++){
            s+=a[i]*Math.sin(Math.PI*x*(i+1)/L);
        }
        return s;
    }

    // Ряд Фурье по косинусам:
    static double FourCos(double x,double[] a){
        int i,N=a.length;
        double s=0;
        for(i=0;i<N;i++){
            s+=a[i]*Math.cos(Math.PI*x*i/L);
        }
        return s;
    }
    
}
