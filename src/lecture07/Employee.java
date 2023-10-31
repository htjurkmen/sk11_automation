package lecture07;

public class Employee {
    private String firstName = null;
    private String lastName = null;
    private int birthYear = 0;

    public Employee() {
        System.out.println("New Employee object created !");
    }

    public Employee(String firstName) {
        this.firstName = firstName;
    }

    public Employee(String firstName, String lastName) {
        //System.out.println("asdfasdf");
        this(firstName, lastName, 9);
        /*this.firstName = firstName;
        this.lastName = lastName;*/
    }

    public Employee(String first, String last, int year) {
        firstName = first;
        lastName = last;
        birthYear = year;
    }


}