import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class MiniGPT {

	private String fileName;
	private int chainOrder;
	private HashMap<String, ArrayList<Character>> book;

	public MiniGPT(String fileName, int chainOrder) {
		this.fileName = fileName;
		this.chainOrder = chainOrder;
		this.book = new HashMap<String, ArrayList<Character>>();
	}

	public HashMap<String, ArrayList<Character>> readData() {
		int i = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			int charAsInt;
			// Read until the end of the stream (-1 is returned)
			String str = "";
			while ((charAsInt = reader.read()) != -1) {
				// Cast the integer value to a character
				char character = (char) charAsInt;
				if (i <= chainOrder) {
					str += character;
					i++;
					continue;
				} else {
					if (book.containsKey(str) == false) {
						ArrayList<Character> nexts = new ArrayList<Character>();
						book.put(str, nexts);
						book.get(str).add(character);
						str = str.substring(1);
						str += character;
					} else {
						book.get(str).add(character);
						str = str.substring(1);
						str += character;
					}
				}

			}
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
		return book;
	}


	public void generateText(String outputFileName, int numChars) {
		String str = "";
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			for (int i = 0; i < chainOrder; i++) {
				str += (char) reader.read();
			}
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
			int i = 0;
			String curr = str;
			writer.write(curr);
			while (i < numChars) {
				char next = predictNextState(curr);
				writer.write(next);
				curr = curr.substring(1);
				curr += next;
				i++;
			}
		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
		}
	}


	public char predictNextState(String curr) {
		ArrayList<Character> nexts = book.get(curr);
		int num = (int) ((Math.random() * 10000) % nexts.size());
		char next = nexts.get(num);
		return next;
	}
}
