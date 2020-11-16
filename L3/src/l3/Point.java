/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3;

import java.lang.Math;

public class Point {
    public double x, y;
    public static Point origin = new Point();
    
    public void clear() {
        x = 0;
        y = 0;
    }

    public double distance (Point that) {
        double xdiff, ydiff;
        System.out.println("x="+x);
        System.out.println("this.x="+this.x);
        System.out.println("that.x="+that.x);
        xdiff = this.x - that.x;
        ydiff = this.y - that.y;
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }
}
