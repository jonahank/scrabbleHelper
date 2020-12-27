import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Brain {

    private HashMap<Character, Set<Word>> indexOfWords;
    private Set<Word> allWords;
    private String filePath;
    private int currentScoreInMind;

    public Brain(String file) throws IOException {
        this.currentScoreInMind = 0;
        this.filePath = file;
        generateAllWords();
        indexAllWords();        
    }

    private void generateAllWords() throws IOException {
        this.allWords = new HashSet<>();
        String filename = filePath;
        try {
            List<String> dataSet = Files.readAllLines(Paths.get(filename));
            for (String string : dataSet) {
                this.allWords.add(new Word(string));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void indexAllWords() throws IOException {
        this.indexOfWords = new HashMap<>();
        char keySets = 'a';
        for (int i = 0; i < 26; i++) {
            Set<Word> valueSets = new HashSet<>();
            for (Word word : allWords) {
                if (word.getName().contains("" + keySets)) {
                    valueSets.add(word);
                }
            }
            this.indexOfWords.put(keySets, valueSets);
            keySets++;
        }
    }

    public ArrayList<Word> findMatchingWords(ArrayList<Character> currentHand) {
        ArrayList<Word> listOfMatchingWords = new ArrayList<>();
        HashSet<Word> matchingWordsAll = new HashSet<>();

        for (Character character : currentHand) {
            for (Word word : indexOfWords.get(character)) {
                word.removeCharacter(character);
                matchingWordsAll.add(word);
            }
        }
        for (Word word : matchingWordsAll) {
            if (word.getEngine().matches("X*")) {
                listOfMatchingWords.add(word);
            }
        }
        return listOfMatchingWords;
    }

    public int getHighScore(){
        return currentScoreInMind;
    }

    public String findBestWord(ArrayList<Character> currentHand) {
        ArrayList<Word> matchingWords = findMatchingWords(currentHand);
        String theWord = "";
        int highestScore = 0;

        for (Word word : matchingWords) {
            if (word.getScore() > highestScore) {
                highestScore = word.getScore();
                theWord = word.getName();
            }
        }
        this.currentScoreInMind = highestScore;
        return theWord;
    }
}
