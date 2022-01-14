package org.hbrs.se1.ws21.uebung11;

public class MyPrettyRectangle {

    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public MyPrettyRectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean contains(MyPrettyRectangle r) {
        if (this.x1 <= r.x1 & this.y1 <= r.y1 & this.x2 >= r.x2 & this.y2 >= r.x2){
            return true;
        }
        return false;
    }

    public MyPoint getCenter() {
        double laenge = x2 - x1;
        double hoehe= y2 - y1;
        MyPoint center = new MyPoint(x1 + laenge/2, y1 + hoehe/2);
        return center;
    }

    public double getArea(){
        return Math.abs((x2 - x1) * (y2  - y1));
    }
    public double getPerimeter(){
        return Math.abs((x2 - x1) + (y2 - y1)) * 2;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o instanceof MyPrettyRectangle){
            MyPrettyRectangle r = (MyPrettyRectangle) o;
            if (Double.compare(this.x1, r.x1) == 0 & Double.compare(this.y1, r.y1) == 0 & Double.compare(this.x2, r.x2) == 0 & Double.compare(this.y2, r.y2) == 0){
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return "MyPrettyRectangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
