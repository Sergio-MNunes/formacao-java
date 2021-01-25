package sg.edu.ntu.tests;
import sg.edu.ntu.classes.Ex0101Circle;

/**
 *  A Test Driver for the Circle class
 */
public class TestEx0101Circle {  // Save as "TestCircle.java"
   public static void main(String[] args) {
      // Declare an instance of Circle class called c1.
      // Construct the instance c1 by invoking the "default" constructor
      // which sets its radius and color to their default value.
      Ex0101Circle c1 = new Ex0101Circle();
      
      // Invoke public methods on instance c1, via dot operator.
      System.out.println("The circle has radius of " 
         + c1.getRadius() + " and area of " + c1.getArea());
      //The circle has radius of 1.0 and area of 3.141592653589793
   
      // Declare an instance of class circle called c2.
      // Construct the instance c2 by invoking the second constructor
      // with the given radius and default color.
      Ex0101Circle c2 = new Ex0101Circle(2.0);
      // Invoke public methods on instance c2, via dot operator.
      System.out.println("The circle has radius of " 
         + c2.getRadius() + " and area of " + c2.getArea());
      //The circle has radius of 2.0 and area of 12.566370614359172
      
      
//-------------------- EXERCICIOS ------------------------
      
      
      // 1. Modify the test program TestCircle to construct an instance of Circle using this constructor.
      Ex0101Circle c3 = new Ex0101Circle(1, "Blue");
      
      // 2. Modify the test program to test this method.
      System.out.println(c3.getColor());
      
      // 3. public vs. private: In TestCircle, can you access the instance variable radius directly (e.g., System.out.println(c1.radius)); or assign a new 
      // value to radius (e.g., c1.radius=5.0)? Try it out and explain the error messages.

      // System.out.println(c1.radius); nao e possivel acessar os atributos diretamente, pois estao setados como privados.

      // 4. Modify the TestCircle to test these methods, e.g.,
      c3.setRadius(5);
      c3.setColor("Yellow");
      
      // 6. Try calling toString() method explicitly, just like any other method:      
      System.out.println("Essa e a saida do metodo toString(): " + c3.toString());
      
      // toString() is called implicitly when an instance is passed to println() method, for example,
      System.out.println(c3);

   }
}