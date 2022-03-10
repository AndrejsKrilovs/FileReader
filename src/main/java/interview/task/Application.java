package interview.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    /**
     * Console application for testing business logic from command line.
     * In this scenario user input is non case sensetive.
     * @param args optional arguments from command line
     * @throws IOException when incorrect input
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Input some string: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inputLineFromKeyboard = in.readLine();

        FileReader application = new FileReader();
        File loadedFile = application.loadFileFromResources("input.txt");
        List<String> loadedDictionary = application.loadDictionaryData(loadedFile);
        List<String> wordsFromString = application.wordsFromInputString(loadedDictionary, inputLineFromKeyboard);

        System.out.printf("String contains %d words: %s", wordsFromString.size(), String.join(", ", wordsFromString));
    }
}
