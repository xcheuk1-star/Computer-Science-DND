// import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        MyArrayList<Dog> dogs = new MyArrayList<Dog>();
        Dog goldretriever = new Dog("hi", "Golden Retriever");
        Dog pug = new Dog("bye", "pug");
        Dog goldlab = new Dog("what", "Golden lab");
        Dog poodle = new Dog("me", "poodle");
        dogs.add(goldretriever);
        dogs.add(goldlab);
        dogs.add(pug);
        dogs.add(poodle);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
        dogs.remove(goldlab);
        // PugSaver.rescuePugs(dogs);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
    }
}
