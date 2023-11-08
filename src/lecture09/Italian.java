package lecture09;

import java.util.List;

public class Italian extends Person{
    public Italian(String name, String sex, String religion,  String hasJob, String egn, String country) {
        super(name, sex, religion, "Italian", hasJob, "Italian", egn, country);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao !");
    }

    public void goodAt(){
        System.out.println("I am making the best pizza in the world !");
    }

    public void makePizza(List<String> ingredients) {
        System.out.println("I am making a pizza with the following ingredients: " + ingredients);
    }
}
