package sg.edu.ntu.classes;
/**
 * The Circle class models a circle with a radius and color.
 */
public class Ex0101Circle {  // Save as "Circle.java"
   // private instance variable, not accessible from outside this class
   private double radius;
   private String color;
   
   // Constructors (overloaded)
   /** Constructs a Circle instance with default value for radius and color */
   public Ex0101Circle() {  // 1st (default) constructor
      this.radius = 1.0;
      this.color = "red";
   }
   
   /** Constructs a Circle instance with the given radius and default color */
   public Ex0101Circle(double radius) {  // 2nd constructor
      this.radius = radius;
      color = "red";
   }
   
   /** Returns the radius */
   public double getRadius() {
     return this.radius; 
   }
   
   /** Returns the area of this Circle instance */
   public double getArea() {
      return radius*radius*Math.PI;
   }
   
   
 //-------------------- EXERCICIOS ------------------------
   
   // 1. Constructor: Modify the class Circle to include a third constructor for constructing a Circle instance with two arguments - a double for radius and a String for color
   public Ex0101Circle(double radius, String color) {  // 3nd constructor
	   this.radius = radius;
	   this.color = color;
   }
   
   // 2. Getter: Add a getter for variable color for retrieving the color of this instance.
   public String getColor() {
	   return this.color;
   }
   
   // 4. Setter: Is there a need to change the values of radius and color of a Circle instance after it is constructed?
   // If so, add two public methods called setters for changing the radius and color of a Circle instance as follows:
   public void setRadius(double radius) {
	   this.radius = radius;
   }
   
   public void setColor(String color) {
	   this.color = color;
   }
   
   // 5. Keyword "this": Instead of using variable names such as r (for radius) and c (for color) in the methods' arguments, it is better to use variable names radius (for radius) 
   // and color (for color) and use the special keyword "this" to resolve the conflict between instance variables and methods' arguments. For example,

   // 6. Method toString(): Every well-designed Java class should contain a public method called toString() that 
   // returns a description of the instance (in the return type of String). The toString() method can be called
   // explicitly (via instanceName.toString()) just like any other method; or implicitly through println().
   // If an instance is passed to the println(anInstance) method, the toString() method of that instance will be invoked implicitly. For example,
   // include the following toString() methods to the Circle class:
   /** Return a self-descriptive string of this instance in the form of Circle[radius=?,color=?] */
   @Override
   public String toString() {
	   return "Circle[radius=" + radius + " color=" + color + "]";
   }

}