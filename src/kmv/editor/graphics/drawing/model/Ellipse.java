package kmv.editor.graphics.drawing.model;

/**
 * @author Mikhail Kovalev
 */
public class Ellipse implements GeometryObject{
    private double circleX;
    private double circleY;
    private double circleA;
    private double circleB;

    public double getCircleX() {
        return circleX;
    }

    public void setCircleX(double pCircleX) {
        circleX = pCircleX;
    }

    public double getCircleY() {
        return circleY;
    }

    public void setCircleY(double pCircleY) {
        circleY = pCircleY;
    }

    public double getCircleA() {
        return circleA;
    }

    public void setCircleA(double pCircleA) {
        circleA = pCircleA;
    }

    public double getCircleB() {
        return circleB;
    }

    public void setCircleB(double pCircleB) {
        circleB = pCircleB;
    }
}
