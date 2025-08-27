import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        Dog one = new Dog("hi", "Golden Retriever");
        Dog two = new Dog("bye", "pug");
        Dog three = new Dog("what", "Golden lab");
        Dog four = new Dog("me", "poodle");
        dogs.add(one);
        dogs.add(two);
        dogs.add(three);
        dogs.add(four);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
        GoldSaver.rescueGolds(dogs);
        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i).toString());
        }
    }
}
