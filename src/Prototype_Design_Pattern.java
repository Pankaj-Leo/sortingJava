public class Prototype_Design_Pattern {

    // Abstract class Shape
    public static abstract class Shape {
        private String color;

        public Shape() {}

        public Shape(Shape source) {
            if (source != null) {
                this.color = source.color;
            }
        }

        public abstract Shape clone();

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    // Concrete class Circle
    public static class Circle extends Shape {
        private int radius;

        public Circle(int radius) {
            this.radius = radius;
        }

        public Circle(Circle source) {
            super(source);
            this.radius = source.radius;
        }

        @Override
        public Shape clone() {
            return new Circle(this);
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }
    }

    // Concrete class Rectangle
    public static class Rectangle extends Shape {
        private int width, height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public Rectangle(Rectangle source) {
            super(source);
            this.width = source.width;
            this.height = source.height;
        }

        @Override
        public Shape clone() {
            return new Rectangle(this);
        }

        public void setDimensions(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    // Main class to test the prototype pattern
    public static void main(String[] args) {
        // Create original shapes
        Circle circle = new Circle(10);
        circle.setColor("Red");

        Rectangle rectangle = new Rectangle(20, 30);
        rectangle.setColor("Blue");

        // Clone shapes
        Circle clonedCircle = (Circle) circle.clone();
        Rectangle clonedRectangle = (Rectangle) rectangle.clone();

        // Modify cloned shapes
        clonedCircle.setRadius(15);
        clonedCircle.setColor("Green");
        // Modify cloned shapes
        clonedRectangle.setDimensions(15,45);
        clonedRectangle.setColor("Green");


        // Print original and cloned objects
        System.out.println("Original Circle: Radius = " + circle.getRadius() + ", Color = " + circle.getColor());
        System.out.println("Cloned Circle: Radius = " + clonedCircle.getRadius() + ", Color = " + clonedCircle.getColor());

        System.out.println("Original Rectangle: Width = " + rectangle.getWidth() + ", Height = " + rectangle.getHeight() + ", Color = " + rectangle.getColor());
        System.out.println("Cloned Rectangle: Width = " + clonedRectangle.getWidth() + ", Height = " + clonedRectangle.getHeight() + ", Color = " + clonedRectangle.getColor());
    }
}