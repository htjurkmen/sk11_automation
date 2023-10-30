package lecture06;

public class Dog extends Animal {
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("I am a dog.");
    }
}