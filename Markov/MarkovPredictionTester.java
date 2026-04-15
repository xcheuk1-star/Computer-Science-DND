import java.util.ArrayList;
import java.util.HashMap;

public class MarkovPredictionTester {
    public static void main(String[] args) {
        MarkovPrediction weathers = new MarkovPrediction();
        weathers.readData("weather.csv");
        // System.out.println(weathers.getCurrent());
        int i = 0;
        while (i < 99999999) {
            System.out.println(weathers.predictNextState("Sunny"));
            i++;
        }
    }
}
