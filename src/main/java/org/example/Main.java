package org.example;


import shapes.*;
import utils.GeometryUtils;

public class Main {

    public static void main(String[] args) {

        Shapes circle = new Circle(4);
        Shapes triangle = new Triangle(5,2,2);
        Shapes rectangle = new Rectangle(2,2);

        System.out.println(circle.area());
        System.out.println(circle.perimeter());

        System.out.println(triangle.area());
        System.out.println(triangle.perimeter());

        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());

        Shapes winnerArea = GeometryUtils.compareAreaShapes(circle,triangle);
        System.out.println(winnerArea.area());

        Shapes winnerPerimeter = GeometryUtils.comparePerimeterShapes(circle,triangle);
        System.out.println(winnerPerimeter.perimeter());

        ThreeDimensionalShapes shapes = new Cube(10);
        System.out.println(shapes.area());



    }
}
