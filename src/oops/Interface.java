package oops;

interface Animal {

    void walk();

}

interface Wild extends Animal {

    int legs = 4; // public static final

    void hunt(); // public abstract

}

class Tiger implements Wild {

    public void walk() {
        System.out.println("walking with" + legs + "legs");
    }

    public void hunt() {
        System.out.println("hunting");
    }
}

public class Interface {

    public static void main(String[] args) {
        Tiger t = new Tiger();
        t.hunt();
        t.walk();
    }

}
