package org.hbrs.se1.ws21.uebung11;

public class BoundingBoxFactory {

    public static MyPrettyRectangle getBoundingBox(MyPrettyRectangle[] rectangles){
        if (rectangles == null){
            return null;
        }
        if (rectangles.length == 0){
            return new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0);
        }
        double smallestX = rectangles[0].getX1();
        double largestX = rectangles[0].getX2();
        double smallestY = rectangles[0].getY1();
        double largestY = rectangles[0].getY2();
        for (MyPrettyRectangle r : rectangles){
            if (r.getX1() < smallestX){
                smallestX = r.getX1();
            }
            if (r.getX2() > largestX){
                largestX = r.getX2();
            }
            if (r.getY1() < smallestY){
                smallestY = r.getY1();
            }
            if (r.getY2() > largestY){
                largestY = r.getY2();
            }
        }
        return new MyPrettyRectangle(smallestX, smallestY, largestX, largestY);
    }
}
