import java.util.ArrayList;
import java.util.List;

public class ShapeTester {

   
    public static void testShapeList(List<? extends Shape> shapes) {
        System.out.println("\nTest Shape List");
        for (Shape s : shapes) {
            s.draw();
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        rectangles.add(new Rectangle());

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle());
        circles.add(new Circle());
        circles.add(new Circle());
        
        List<Shape> mixedShapes = new ArrayList<>();
        mixedShapes.add(new Rectangle());
        mixedShapes.add(new Circle());
        
        
        testShapeList(rectangles);
        testShapeList(circles);
        testShapeList(mixedShapes);
    }
}