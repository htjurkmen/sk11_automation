package lecture08.exercises.shape;

public class Exercises {
    public static void main(String[] args) {
        Circle s1 = new Circle();
        System.out.println(s1.getArea(3.0));
        System.out.println(s1);

        Shape s2 = new Circle(); // Upcast Circle to Shape
        System.out.println(s2.getArea(3.0));
        System.out.println(s2);

        Circle s3 = (Circle) s2; // Downcast back to Circle
        System.out.println(s3);
        System.out.println(s2.getPerimeter(3.0));

//        Square s4 = new Shape();

        Square s5 = new Square();
        System.out.println(s5.getArea(6.0));
        System.out.println(s5.getPerimeter(6.0));


         /*// Upcasting and Downcasting in order to try it uncomment classes below
        Parent p = new Child();
        p.name = "p variable name gets value";

        //Printing the parentclass name
        System.out.println(p.name);
        //parent class method is overridden method hence this will be executed
        p.method();

        // Trying to Downcasting Implicitly
        //Child c = new Parent(); - > compile time error

        // Downcasting Explicitly
        Child c = (Child)p;

        c.id = 1;
        System.out.println(c.id);
        c.method();*/

    }

}

/*
// Parent class
class Parent {
    String name;

    // A method which prints the
    // signature of the parent class
    void method()
    {
        System.out.println("Method from Parent");
    }

}

// Child class
class Child extends Parent {
    int id;

    // Overriding the parent method
    // to print the signature of the
    // child class
    @Override void method()
    {
        System.out.println("Method from Child");
    }

}*/
