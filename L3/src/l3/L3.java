/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3;


public class L3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //pointFoo();
        //vehicleFoo();
        mathDemoFoo();
    }
    
    public static void pointFoo(){
        Point lowerLeft = new Point();
        Point upperRight = new Point();
        Point middlePoint = new Point();
        
        lowerLeft.x = 0.0;
        lowerLeft.y = 0.0;
        upperRight.x = 1280.0;
        upperRight.y = 1024.0;
        middlePoint.x = 640.0;
        middlePoint.y = 512.0;
        
        System.out.println("lower left > "+lowerLeft.x+","+lowerLeft.y);
        System.out.println("upper Right > "+upperRight.x+","+upperRight.y);
        System.out.println("middle Point > "+middlePoint.x+","+middlePoint.y);
        
        System.out.println("origin Point > "+Point.origin.x+","+Point.origin.y);
        
        middlePoint.clear();
        System.out.println("middle Point > "+middlePoint.x+","+middlePoint.y);
        
        double d = upperRight.distance(middlePoint);
        System.out.println("d = "+d);
    }
    
    public static void vehicleFoo(){
        Vehicle vehicle = new Vehicle();
        vehicle.owner = "Admin";
        vehicle.direction = 125.5;
        vehicle.speed = 75.2;
        
        System.err.println(vehicle.owner+" runs to the "+vehicle.direction+"* by "+vehicle.speed+" km/h.");
    }
    
    public static void mathDemoFoo() {
        System.out.println("Примеры вызова функций:");
        // Вычисление экспоненты:
        System.out.println("exp(1)="+MathDemo.Exp(1,30));
        // Вычисление синуса:
        System.out.println("sin(pi)="+MathDemo.Sin(Math.PI,100));
        // Вычисление косинуса:
        System.out.println("cos(pi/2)="+MathDemo.Cos(Math.PI/2,100));
        // Вычисление функции Бесселя:
        System.out.println("J0(mu1)="+MathDemo.BesselJ(2.404825558,100));
        // Заполнение массивов коэффициентов рядов Фурье для функции y(x)=x:
        int m=1000;
        double[] a=new double[m];
        double[] b=new double[m+1];
        b[0]=MathDemo.L/2;
        for(int i=1;i<=m;i++){
            a[i-1]=(2*(i%2)-1)*2*MathDemo.L/Math.PI/i;
            b[i]=-4*(i%2)*MathDemo.L/Math.pow(Math.PI*i,2);
        }
        
        // Вычисление функции y(x)=x через синус-ряд Фурье:
        System.out.println("2.0->"+MathDemo.FourSin(2.0,a));
        // Вычисление функции y(x)=x через косинус-ряд Фурье:
        System.out.println("2.0->"+MathDemo.FourCos(2.0,b));
        //Факториал
        System.out.println("5.0->"+MathDemo.Factorial(5.0));
        
        System.out.println("625.0->"+MathDemo.Pow(16.0));
    }
    
}
