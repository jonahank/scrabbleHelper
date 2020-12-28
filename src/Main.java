import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Hand myHand = new Hand();
        Brain myBrain = new Brain("lib/words.txt");
        String userInput = "";

        while (true) {

            System.out.println("Type in the letters in your hand as one word!");
            System.out.println("(type 'exit' to exit the scrabbleHelper v1.0)");
            userInput = sc.nextLine().toLowerCase();
            if (userInput.equals("exit")) {
                break;
            }
            System.lineSeparator();
            System.out.println("The best possbile word to construct is:");
            
            ArrayList<Character> customHand = myHand.defineHand(userInput);
            String bestWord = myBrain.findBestWord(customHand);
            System.out.println(bestWord + " giving " + myBrain.getHighScore() + " points!");
            System.out.println("");
                
        }

        sc.close();

        
    
    }
    


    
}
