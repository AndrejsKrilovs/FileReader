package interview.task;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileReaderTest {
    private final FileReader fileReader = new FileReader();

    @Test
    public void loadExistingFileFromResources() {
        File file = fileReader.loadFileFromResources("test.txt");
        Assert.assertTrue(file.exists());
    }

    @Test(expected = RuntimeException.class)
    public void loadNotExistFileFromResources() {
        fileReader.loadFileFromResources("some.file");
    }

    @Test
    public void readDictionaryData() {
        File file = fileReader.loadFileFromResources("test.txt");
        List<String> dictionaryData = fileReader.loadDictionaryData(file);
        Assert.assertEquals(3, dictionaryData.size());
    }

    @Test(expected = RuntimeException.class)
    public void readDataFromNotExistingFile() {
        File file = fileReader.loadFileFromResources("some.file");
        fileReader.loadDictionaryData(file);
    }

    @Test
    public void readFromKeyboard() {
        File file = fileReader.loadFileFromResources("test.txt");
        List<String> dictionaryData = fileReader.loadDictionaryData(file);
        List<String> wordsFromString = fileReader.wordsFromInputString(dictionaryData, "djkhofjkhacatalogdsahf");
        Assert.assertEquals(3, wordsFromString.size());
        Assert.assertEquals(Arrays.asList("cat","a","log"), wordsFromString);
    }
}