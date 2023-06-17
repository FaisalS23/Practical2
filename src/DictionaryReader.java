import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryReader {
    public static void main(String[] args) {
        String filePath = ".\\src\\Files\\file.txt"; // Need A Actual File Path since none was given

        // Check if the file exists
        if (doesFileExist(filePath)) {
            // Read and print the word and its meanings
            readAndPrintDictionary(filePath);
        } else {
            System.out.println("File does not exist.");
        }
    }

    // Method to check if the file exists
    private static boolean doesFileExist(String path) {
        try {
            FileReader fileReader = new FileReader(path);
            fileReader.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Method to read and print the dictionary
    private static void readAndPrintDictionary(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ", 2);
                String word = parts[0];
                String meanings = parts[1];
                String[] meaningsArr = meanings.split(", ");

                // Print the word
                System.out.println(word);

                // Print the meanings
                for (String meaning : meaningsArr) {
                    System.out.println(meaning);
                }

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}
