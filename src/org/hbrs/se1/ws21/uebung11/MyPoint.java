package org.hbrs.se1.ws21.uebung11;

public class MyPoint {

    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof MyPoint){
            MyPoint p = (MyPoint) o;
            if (this == p){
                return true;
            }
            return Double.compare(this.x, p.x) == 0 & Double.compare(this.y, p.y) == 0;
        }
        return false;
    }

    public String toString(){
        return "(" + x + ")" + " " + "(" + y + ")";
    }
}
