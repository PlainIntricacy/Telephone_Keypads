package telkpad;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author todyertuz @ plainintricacy.wordpress.com
 * Java code that simulates a telephone keypad with AutoComplete function.
 * Based on this reddit daily challenge: http://goo.gl/SdX0Z4
 */
public class TelKpad {
    
    public static String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your numbers");
        String in = input.nextLine();
        input.close();
        String output = new String();
        
        String[] kpad = new String[8];
        kpad[0] = "ABC";
        kpad[1] = "DEF";
        kpad[2] = "GHI";
        kpad[3] = "JKL";
        kpad[4] = "MNO";
        kpad[5] = "PQRS";
        kpad[6] = "TUV";
        kpad[7] = "WXYZ";
        
        if(isValidInput(in)){
        String[] numbers = in.split(" ");
        int[] nums = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            if(isValidNumber(Integer.parseInt(numbers[i]))){
                nums[i] = Integer.parseInt(numbers[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                if(numsize(nums[i])>kpad[nums[i]%10-2].length()){
                    output+=kpad[nums[i]%10-2].charAt(numsize(nums[i])-(kpad[nums[i]%10-2].length())-1);
                }else{
                    output+=kpad[nums[i]%10-2].charAt(numsize(nums[i])-1);
                }
            }
        }
        if(output!=null){
            System.out.println(output.toLowerCase());
            System.out.println("AutoComplete suggestions:");
            System.out.println("----------------------------------------");
            String word = new String();
            FileInputStream dictionary = new FileInputStream("C:/Users/Irukandji/Documents/NetBeansProjects/TelKPad/src/telkpad/brit-a-z.txt");
            BufferedReader dictreader = new BufferedReader(new InputStreamReader(dictionary));
            word = dictreader.readLine();
            while(word!=null){
                if(word.startsWith(output.toLowerCase())){
                    System.out.println(word);
                }
                word=dictreader.readLine();
            }
            dictionary.close();
            dictreader.close();
        }else{
            System.out.println("This should never happen.");
        }            
        System.out.println("----------------------------------------");
    }else System.out.println("Invalid input");
    }
    
    public static boolean isValidInput(String q){
        String[] letters = alphabet.split(" ");
        for(int i=0; i<letters.length; i++){
            if(q.contains(letters[i])){
                return false;
            }
        }
        return true;
    }
     
    public static boolean isValidNumber(int x){
        int q=x%10;
        if(q==1||q==0){
            return false;
        }
        while(x>0){
            if(x%10!=q){
                return false;
            }
            x/=10;
        }
        return true;
    }
    
    public static int numsize(int q){
        int x=0;
        while(q>0){
            x++;
            q/=10;
        }
        return x;
    }
}
