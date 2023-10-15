package App;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * The WordReader class provides methods for reading random words from a file.
 */
public class WordReader {

    /**
     * Get the number of lines in a given file.
     *
     * @param file The file to count lines from.
     * @return The number of lines in the file.
     */
    private static long getAmountOfLine(File file) {
        long fileLength = 0;
        try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
            while (lnr.readLine() != null) {
                fileLength = lnr.getLineNumber();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileLength;
    }

    /**
     * Get a list of words from the given file.
     *
     * @param file The file to read words from.
     * @return A list of words read from the file.
     */
    private static List<String> getWords(File file) {
        ArrayList<String> wordList = new ArrayList<>();
        try (Scanner fileReader = new Scanner(file)) {
            while (fileReader.hasNextLine()) {
                wordList.add(fileReader.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return wordList;
    }

    /**
     * Retrieve a random word from the provided file.
     *
     * @param file The file containing words to choose from.
     * @return A randomly selected word from the file.
     */
    public static String retrieveWord(File file) {
        Random rand = new Random();
        return getWords(file).get(rand.nextInt((int) getAmountOfLine(file)));
    }
}
