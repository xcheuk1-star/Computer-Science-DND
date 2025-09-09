import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<Dog>();
        // Dog goldretriever = new Dog("hi", "Golden Retriever");
        // Dog pug = new Dog("bye", "pug");
        // Dog goldlab = new Dog("what", "Golden lab");
        // Dog poodle = new Dog("me", "poodle");
        // dogs.add(goldretriever);
        // dogs.add(goldlab);
        // dogs.add(pug);
        // dogs.add(poodle);
        // for (int i = 0; i < dogs.size(); i++) {
        //     System.out.println(dogs.get(i).toString());
        // }
        for (int i = 0; i < 9999999; i ++) {
            if (i % 2 == 0) {
                dogs.add(new Dog("Waller", "Poodle"));
            } else {
                dogs.add(new Dog("Evan", "Golden"));
            }
        }
        PugSaver.rescuePugs(dogs);
        System.out.println("exited rescue pugs");
        System.out.println(dogs.toString());
        // dogs.remove(goldlab);
        // // PugSaver.rescuePugs(dogs);
        // for (int i = 0; i < dogs.size(); i++) {
        //     System.out.println(dogs.get(i).toString());
        // }
    }
}
