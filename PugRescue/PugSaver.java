// import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Gold something" in the list to the back of the list
	public static void rescuePugs(MyArrayList<Dog> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().indexOf("Gold") != -1) {
				for (int j = list.size() - 1; j > 0; j--) {
					if (list.get(j).getBreed().indexOf("Gold") == -1) {
						if (i < j) {
							Dog temp = list.get(i);
							Dog temp2 = list.get(j);
							list.set(i, temp2);
							list.set(j, temp);
						}
					}
				}
			}
		}
	}
}

