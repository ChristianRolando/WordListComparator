import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordListComparatorDemo {
    public static void main(String[] args) {
        //Initialize an ArrayList to store our individual words in.
        List<String> words = new ArrayList<>();
        List<WordListComparator> wordsList = new ArrayList<>();
        //Prompt our user for the file name, close our keyboard scanner after.
        System.out.print("Please provide the file name, including the file extension: ");
        Scanner keyboard = new Scanner(System.in);
        String filename = keyboard.nextLine();

        keyboard.close();
        //Initialize File object reader, read our file, separate our words using whitespace as separator.
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineWords = line.split("\\s+");

                for (String word : lineWords) {
                    WordListComparator wordComparator = new WordListComparator(word);
                    wordsList.add(wordComparator);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        }

        System.out.println("These are your words: " );
        for(WordListComparator wordListComparator : wordsList) {
            System.out.print(wordListComparator.getWord() + ", ");
        }
        System.out.println();

        Collections.sort(wordsList, new WordListComparator());

        System.out.println("Sorted words list:");
        for (WordListComparator wordListComparator : wordsList) {
            System.out.println(wordListComparator.getWord() + " - Score: " + wordListComparator.getScore());
        }
    }
}





