import java.util.Locale;
import java.util.Scanner;

public class Assignment5Driver {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("[DNA Reverser and Translator]");
        System.out.print("Enter a sequence: ");
        String userSequence = myScan.nextLine();
        String allCaps = userSequence.toUpperCase(Locale.ROOT);
        boolean isValid = DNALib.validator(allCaps);
        if (isValid) {
            String reversed = DNALib.reverser(allCaps);
            String inverted = DNALib.inverser(reversed);
            String translated = DNALib.translator(inverted);
            System.out.println("Your DNA sequence reversed and translated is: ");
            System.out.println(translated);
        }
        else {
            System.out.println("Your DNA sequence is not valid.");
        }
    }
}
