import java.util.ArrayList;
import java.util.Scanner;

public class MainControler {
    String szo = "Unikornis";
    String szoLower = szo.toLowerCase();
    Scanner scanner = new Scanner(System.in);
    int iscounter = 0;
    int isappended = 0;
    int notcounter = 0;
    int alreadyTried = 0;
    String inputStr = "";
    String[] szoTomb = new String[szoLower.length()];
    StringBuilder guesses = new StringBuilder();
    public MainControler() {
        String firstChar ="";
        do {
            System.out.println("Adj meg egy betűt, hogy teszteld benne van-e a szóban!");
            System.out.println("A szó hossza: "+ szo.length());
            inputStr = scanner.nextLine();
            firstChar = String.valueOf(inputStr.charAt(0));
            
            if (guesses.indexOf(firstChar)!=-1) {
                System.out.println("Már próbáltad ezt a betűt: "+firstChar);
                alreadyTried++;
                continue;
            }else{
                guesses.append(firstChar);
            
                // System.out.println(firstChar+inputStr);
                // System.out.println(szoLower.contains(firstChar));
                if (firstChar.equals("0")) {
                    break;
                }
                else if (szoLower.contains(firstChar)) {
                    Indexer indexer = new Indexer();
                    ArrayList<Integer> charIndexes = indexer.findIndexes(szoLower, firstChar);
                    for(int i = 0; i < charIndexes.size(); i++) {
                        Integer index = charIndexes.get(i);
                        szoTomb[index] = firstChar;
                        isappended++;
                    }
                    iscounter++;
                    charIndexes.clear();
                
                }
                else if (!szoLower.contains(firstChar)) {
                    System.out.println("Nem tartalmazza, próbáld újra!");
                    notcounter++;
                } 
                // for(int i = 0; i < szoTomb.length; i++){
                //     System.out.println(szoTomb[i]);
                //     System.out.println(iscounter);
                // }
                if (isappended==szo.length()) {
                    System.out.println("Gratulálok, megtaláltad az összes betűt, a szó: "+ szo);
                    int allTries = iscounter + notcounter + alreadyTried;
                    System.out.println(allTries+" betűvel próbálkoztál");
                    System.out.println(alreadyTried+" alkalommal próbálkoztál olyan betűvel, amit korábban már beírtál");
                    System.out.println(notcounter+"db egyedi betűvel próbálkoztál amit nem tartalmazott a szó");
                    System.out.println(iscounter+"db egyedi betűt találtál ki helyesen");
                    break;
                }
            }
        } while (!firstChar.equals("0"));
    }
    
}
