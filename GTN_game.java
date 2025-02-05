import java.util.Scanner;
import java.util.Random;
 public class GTN_game {
   public static void main(String[]args){
     Scanner sc = new Scanner(System.in);
     System.out.println("LET THE GAME BEGIN");
     Random rd = new Random();
     int n = rd.nextInt(100);
    System.out.println("Guess the number: "); 
     int tries = 0;
     for (int i = 0;i<100;i++){
     int a = sc.nextInt();
       if(a<n){
   System.out.println("Provide a bigger number: "); 
      tries +=1;
       } else if(a>n){
         System.out.println("Provide a lesser number: "); 
        tries += 1;
       } else if(a==n){
         System.out.println("Hurray!You have guessed the right answer . 7 crore✨"); 
      
         break;
       }  
   }
     System.out.println("You have taken this number of tries for guessing the number: "); 
     System.out.print(tries + 1); 
 }
 }
       