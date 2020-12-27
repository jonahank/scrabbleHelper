import java.util.ArrayList;

public class Hand {

    private ArrayList<Character> lettersOnHand;
    private int numberOfCharsOnHand;

    public Hand() {
        this.numberOfCharsOnHand = 8;
        initializeHand();

    }

    public ArrayList<Character> defineHand(String allLetters){
        ArrayList<Character> customizedHand = new ArrayList<>();
        char[] individualLetters = allLetters.toCharArray();
        for (char c : individualLetters) {
            customizedHand.add(c);
        }
        return customizedHand;
    }

    public ArrayList<Character> getSimpleHand(){
        ArrayList<Character> simpleHand = new ArrayList<>();
        simpleHand.add('a');simpleHand.add('a');

        return simpleHand;
    }

    public ArrayList<Character> getHand(){
        return this.lettersOnHand;
    }

    private void initializeHand() {
        lettersOnHand = new ArrayList<>();
        char randomChar = 'a';
        int randomizer = 0;
        for (int i = 0; i < this.numberOfCharsOnHand; i++) {
            randomizer = (int) Math.floor(Math.random() * 26);
            randomChar += randomizer;
            /*
             * System.out.println(randomizer); System.out.println(randomChar);
             */
            lettersOnHand.add(randomChar);
            randomChar = 'a';
        }

    }
}
