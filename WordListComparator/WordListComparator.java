import java.util.Comparator;
import java.lang.*;
import java.util.Map;
class WordListComparator implements Comparator<WordListComparator> {
    private String word;
    private int score;

    public WordListComparator(String word) {
        this.word = word;
        this.score = calculateScore(word);
    }
    public WordListComparator() {

    }

    public String getWord() {
        return word;
    }

    public int getScore() {
        return score;
    }

    //Compare method is here ========================================
    public int compare(WordListComparator comparator1, WordListComparator comparator2) {
        int score1 = comparator1.score;
        int score2 = comparator2.score;

        return score1 - score2;
    }

    private int calculateScore(String word) {
        Map<Character, Integer> letterPoints = Map.ofEntries(
                Map.entry('A', 1), Map.entry('E', 1), Map.entry('I', 1), Map.entry('O', 1),
                Map.entry('U', 1), Map.entry('L', 1), Map.entry('N', 1), Map.entry('S', 1),
                Map.entry('T', 1), Map.entry('R', 1), Map.entry('D', 2), Map.entry('G', 2),
                Map.entry('B', 3), Map.entry('C', 3), Map.entry('M', 3), Map.entry('P', 3),
                Map.entry('F', 4), Map.entry('H', 4), Map.entry('V', 4), Map.entry('W', 4),
                Map.entry('Y', 4), Map.entry('K', 5), Map.entry('J', 8), Map.entry('X', 8),
                Map.entry('Q', 10), Map.entry('Z', 10));

        int score = 0;
        for (char c : word.toCharArray()) {
            score += letterPoints.get(Character.toUpperCase(c));
        }
        return score;
    }
}

