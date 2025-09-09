import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Gold something" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		int lastNonGold = list.size() - 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().indexOf("Gold") != -1) {
				for (int j = lastNonGold; j > i; j--) {
					if (list.get(j).getBreed().indexOf("Gold") == -1) {
						if (i < j) {
							lastNonGold = j;
							Dog temp = list.get(i);
							Dog temp2 = list.get(j);
							list.set(i, temp2);
							list.set(j, temp);
							break;
						}
					}
				}
			}
		}
	}
}

