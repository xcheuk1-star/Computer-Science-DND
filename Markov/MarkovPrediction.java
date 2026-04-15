import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPrediction {

    // Please define your own variables and data structures
    //

    private HashMap<String, ArrayList<String>> current;

    MarkovPrediction() {
        this.current = new HashMap<String, ArrayList<String>>();
    }

    public HashMap<String, ArrayList<String>> getCurrent() {
        return current;
    }

    public HashMap<String, ArrayList<String>> readData(String filePath) {
        // HashMap<String, ArrayList<String>> current = new HashMap<String, ArrayList<String>>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] items = line.split(",");
                if (current.containsKey(items[0]) == false) {
                    ArrayList<String> nexts = new ArrayList<String>();
                    current.put(items[0], nexts);
                    current.get(items[0]).add(items[1]);
                } else {
                    current.get(items[0]).add(items[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return current;
    }


    // Method to predict the next state given a current state
    public String predictNextState(String currentState) {
        ArrayList<String> nexts = current.get(currentState);
        int num = (int) ((Math.random() * 10000) % nexts.size());
        String next = nexts.get(num);
        return next;
    }

}
