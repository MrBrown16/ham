import java.util.Scanner;

public class MainControler {
    String szo = "Unikornis";
    Scanner scanner = new Scanner(System.in);
    int iscounter = 0;
    int notcounter = 0;
    String inputStr = "";
    String[] szoTomb = new String[szo.length()];
    public MainControler() {
        do {
            inputStr = scanner.nextLine();
            String firstChar = toString(inputStr.charAt(0));
            if (szo.contains(firstChar)) {
                szoTomb[szo.indexOf(firstChar)] = firstChar;
                iscounter++;
            }
            else if (!szo.contains(firstChar)) {
                notcounter++;
            } 
            
        } while (!firstChar.equals("0"));
    }
    
}
