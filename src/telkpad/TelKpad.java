package telkpad;
import java.util.Scanner;

/**
 *
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
    }
}
