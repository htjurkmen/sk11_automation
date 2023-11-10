package lecture09;

public class American extends Person{
    public American(String name, String sex, String religion, String hasJob, String egn, String country) {
        super(name, sex, religion, "English", hasJob, "American", egn, country);
    }

    public void celebrateThanksGiving(){
        System.out.println("I am celebrating Thanksgiving on the fourth Tuesday of November ! ");
    }

}
