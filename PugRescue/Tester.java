// import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        MyArrayList<Dog> dogs = new MyArrayList<Dog>();
        Dog hi = new Dog("hi", "Golden Retriever");
        Dog bye = new Dog("bye", "pug");
        Dog what = new Dog("what", "Golden lab");
        Dog me = new Dog("me", "poodle");
        dogs.set(0, hi);
        dogs.set(1, bye);
        dogs.set(2, what);
        dogs.set(3, me);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
        PugSaver.rescuePugs(dogs);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
    }
}
