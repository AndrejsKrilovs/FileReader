package interview.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * File reader class for first task.
 */
public class FileReader {
    /**
     * Loads file from resource folder.
     * @param fileName is name of file
     * @return loaded file
     */
    public File loadFileFromResources(String fileName)  {
        File result = null;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = Optional.ofNullable(classLoader.getResource(fileName))
                    .orElseThrow(RuntimeException::new);
            result = new File(resource.toURI());
        } catch (URISyntaxException e) {
           throw new RuntimeException(e.getMessage());
        }

        return result;
    }

    /**
     * Load dictionary data from file
     * @param file is document with dictionary data
     * @return list of words from file
     */
    public List<String> loadDictionaryData(File file) {
        List<String> resultCollection;

        try {
            resultCollection = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return resultCollection;
    }

    /**
     * Parsing input string to dictionary words
     * @param dictionary is list with words from provided file
     * @param stringFromInput is user input from keyboard
     * @return founded words in user's input represented as List
     */
    public List<String> wordsFromInputString(List<String> dictionary, String stringFromInput) {
        return dictionary.stream()
                .filter(stringFromInput::contains)
                .collect(Collectors.toList());
    }
}
