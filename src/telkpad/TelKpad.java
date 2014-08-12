package telkpad;
import java.util.Scanner;
/**
 *
 * @author todyertuz @ plainintricacy.wordpress.com
 * Java code that simulates a reverse telephone keypad (takes a word or sentence, and returns the appropriate keypad number sequence).
 * Based on this reddit daily challenge: http://goo.gl/SdX0Z4
 */
public class TelKpad {
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your sentence:");
        String in = input.nextLine();
        input.close();
        
        String[] kpad = new String[8];
        kpad[0] = "ABC";
        kpad[1] = "DEF";
        kpad[2] = "GHI";
        kpad[3] = "JKL";
        kpad[4] = "MNO";
        kpad[5] = "PQRS";
        kpad[6] = "TUV";
        kpad[7] = "WXYZ";
        
        String[] words = in.toUpperCase().split(" ");
        
        System.out.println("Conversion complete:");
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                for(int q=0; q<kpad.length; q++){
                    if(kpad[q].indexOf(words[i].charAt(j))>=0){
                        for(int z=0; z<=kpad[q].indexOf(words[i].charAt(j)); z++){
                            System.out.print(q+2);                            
                        }
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
