import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DirectedGraph {


    public static List<String> readAllLines() {
        List<String> names = new List<String>();
        try {


            // Each element is one line from the file
            Path p = Paths.get("NameOfYourFile.txt");
            return (List<String>) Files.readAllLines(p);
        } catch (Exception e) {
            System.out.println("Couldn’t read file");
        }
        return names;
    }
}


