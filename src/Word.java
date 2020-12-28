public class Word {

    private int score;
    private String name;
    private String engine;
    private LetterPoints pointSystem;

    public Word(String word){
        this.name = word;
        this.engine = word;
        this.pointSystem = new LetterPoints();
        calculateScore();
    }

    private void calculateScore() {
        int helperScore = 0;
        for (Character letter : name.toCharArray()) {
            helperScore += pointSystem.scoreLetter(letter);
        }
        this.score = helperScore;
    }

    public String getName(){
        return this.name;
    }

    public int getScore(){
        return this.score;
    }

    public String getEngine(){
        return this.engine;
    }

    public void removeCharacter(char characterToRemove){
        String modifiedWord = "";
        boolean moreToRemove = true;
        for (Character character : engine.toCharArray()) {
            if (character.equals(characterToRemove) && moreToRemove) {
                character = 'X';
                moreToRemove = false;            
            }
            modifiedWord += character;
        }
        this.engine = modifiedWord;
    }
    
}
