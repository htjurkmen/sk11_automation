package lecture09;

public class Child extends Person {
    public Child(String name, String sex, String religion, String language, String hasJob, String nationality, String egn, String country) {
        super(name, sex, religion, language, hasJob, nationality, egn, country);
    }

    @Override
    public void sayHello() {
        System.out.println("Ga ga gu gu ");
    }

    @Override
    public void setHasJob(String hasJob) {
        throw new IllegalArgumentException("I do not have a job !");
    }

    @Override
    public boolean canTakeLoan() {
        System.out.println("Can take money only from my parents");
        return false;
    }

    @Override
    public boolean isAdult() {
        System.out.println("The child is not an adult.");
        return false;
    }

    public void play(String toy) {
        System.out.println("I am playing with a " + toy);
    }


}
