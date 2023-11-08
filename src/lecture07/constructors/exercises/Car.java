package lecture07.constructors.exercises;

public class Car {
    private String name;
    private String color;
    private int releaseYear;
    private int horsePower;
    private boolean secondHand;

//    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHand) {
//        this.name = name;
//        this.color = color;
//        this.releaseYear = releaseYear;
//        this.horsePower = horsePower;
//        this.secondHand = secondHand;
//    }

    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHand) {
        if (name == null || name.isEmpty()) {
            this.name = "N/A";
        } else {
            this.name = name;
        }

        if (color == null || color.isEmpty()) {
            this.color = "N/A";
        } else {
            this.color = color;
        }

        if (releaseYear < 0) {
            this.releaseYear = -1;
        } else {
            this.releaseYear = releaseYear;
        }

        if (horsePower < 0) {
            this.horsePower = -1;
        } else {
            this.horsePower = horsePower;
        }

        this.secondHand = secondHand;
    }

    public Car(String name, String color, boolean secondHand) {
        this(name, color, -1, -1 , secondHand);
    }

    public Car(String name, String color, int releaseYear, int horsePower) {
        this(name, color, releaseYear, horsePower, false);
    }

    public Car(String name, int releaseYear, int horsePower, boolean secondHand) {
        this(name, "N/A", releaseYear, horsePower, secondHand);
    }



    public Car() {
    }
}