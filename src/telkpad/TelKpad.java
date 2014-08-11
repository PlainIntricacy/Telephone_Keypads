package telkpad;
import java.util.Scanner;
<<<<<<< HEAD
/**
 *
 * @author todyertuz @ plainintricacy.wordpress.com
 * Java code that simulates a telephone keypad.
 * Based on this reddit daily challenge: http://goo.gl/SdX0Z4
 */
public class TelKpad {
    
    public static String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your numbers");
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
        
        if(isValidInput(in)){
        String[] numbers = in.split(" ");
        int[] nums = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            if(isValidNumber(Integer.parseInt(numbers[i]))){
                nums[i] = Integer.parseInt(numbers[i]);
            }
        }
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                if(numsize(nums[i])>kpad[nums[i]%10-2].length()){
                    System.out.print(kpad[nums[i]%10-2].charAt(numsize(nums[i])-(kpad[nums[i]%10-2].length())-1));
                }else{
                    System.out.print(kpad[nums[i]%10-2].charAt(numsize(nums[i])-1));
                }
            }
        }
        System.out.println("");
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
=======

/**
 * Java code that simulates a telephone keybad. Based on this reddit daily challenge: http://goo.gl/SdX0Z4
 * @author todyerutz @ plainintricacy.wordpress.com
 */
public class TelKpad {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Please enter your numbers:");
        String nums = input.nextLine();
        input.close();
        
        
    }
    public static boolean isValid(int x){
            int i = x%10;
            if(i!=1){
            while(x!=0){
                if(i!=x%10){
                    return false;
                }
                x=x/10;
            }
            }
            return true;
        }
    
    public static int calcsize(int x){
        int q=0;
        while(x>0){
            x/=10;
            q++;
        }
        return q;
    }
    
    public void splitup(String x){
        String parts[] = x.split(" ");
        int nums[] = new int[parts.length-1];
        for(int i=0; i<parts.length; i++){
            nums[i] = Integer.parseInt(parts[i]);
        }
>>>>>>> 32e2eb4565bda8ec4e0a6939bb1961b27d25f7d8
    }
}
