package sg.edu.ntu.classes;
public class Ex0103Rectangle {

	private float length;
	private float width;
	
	public Ex0103Rectangle() {
		
	}

	public Ex0103Rectangle(float length, float width) {
		this.length = length;
		this.width = width;
	}
	
	public float getLength() {
		return length;
	}
	
	public void setLength(float length) {
		this.length = length;
	}
	
	public float getWidth() {
		return this.length;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getArea() {
		return this.width * this.length;
	}
	
	public float getPerimeter() {
		return this.width*2 + this.length*2;
	}
	
	public String toString() {
		return "Rectangle[length=" + this.length + ",width=" + this.width + "]";
	}
}