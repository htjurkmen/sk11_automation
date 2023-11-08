package lecture09;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

    public static void main(String[] args) {

        //Person object
        Person pesho = new Person("Petur", "male", "Orthodox", "Bulgarian", "Plumber", "Bulgarian", "9805105456",  "Bulgaria");
        pesho.celebrateEaster();
        pesho.canTakeLoan();
        pesho.setCountry("Brasil");
        pesho.getCountry();

        //Bulgarian object
        Bulgarian bulgarian = new Bulgarian("Petur", "male", "Orthodox",  "Plumber", "9805105456",  "Bulgaria");
        bulgarian.sayHello();
        bulgarian.danceHoro();
        bulgarian.getCountry();
        System.out.println(bulgarian.isAdult());

        //Italian object
        Italian francesco = new Italian("Francesco", "male", "catholic", "Car maker", "7605108945", "Italy");
        francesco.goodAt();
        List<String> ingredients = new ArrayList<>();
        ingredients.add("water");
        ingredients.add("flour");
        ingredients.add("eggs");
        ingredients.add("cheese");
        francesco.makePizza(ingredients);

    }

}
