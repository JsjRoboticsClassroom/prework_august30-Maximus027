package nyc.c4q;

public class Main {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        while (hangman.getMisses() < 5){
            hangman.printCurrentWord();
            hangman.promptPlayer("Enter a letter: ");
            hangman.readLetter();
            hangman.checkLetter();
            if(hangman.guessedSuccessfully()){
                break;
            }
            System.out.println(Drawing.get(hangman.getMisses()));
            System.out.println("Misses -> " +hangman.getMisses());
        }
        if(hangman.guessedSuccessfully()){
            System.out.println("Success");
        } else {
            System.out.println("The answer was " + hangman.getSecretWord());
        }
        playAgain();
    }
    
    public static boolean playAgain() {
        boolean runAgain = false;
        boolean anotherOne = true;
        do {
            System.out.println( "Play again? " );
            Scanner isPlayingAgain = new Scanner( System.in );
            String userResponse = isPlayingAgain.next();
            userResponse = userResponse.toLowerCase();

            if ( userResponse.equals( "yes" ) || runAgain.equals( "y" ) ) {
                runAgain = true;
                return runAgain;
            }
            if ( runAgain.equals( "no" ) || runAgain.equals( "n" ) ) {
                runAgain = false;
                return runAgain;
            } else {
                System.out.println( "Not a valid answer. Try again." );
                continue;
            }
        } while( anotherOne );
            return runAgain;
        }
}
