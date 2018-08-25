import java.util.Scanner;
import shapes.Circle;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your name: ");
        String name = scanner.next();
        System.out.println("hello " + name);
        Circle c = new Circle(3,4,65);
    }

}
class MyExtendedCircle extends Circle{
    public MyExtendedCircle(int x, int y, int radius){
        super(x,y,radius);
    }
}