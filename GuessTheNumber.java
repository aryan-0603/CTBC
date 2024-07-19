import java.util.*;

public class task1{
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        System.out.print("Please enter the no. to start the game : ");
        Scanner sc = new Scanner(System.in);
        int x = 1;
        while(x<6){
            int n = sc.nextInt();
            if (n<randomNumber && x<5) {
                System.out.println("The number is greater than the given no.");
            }
            else if(n>randomNumber && x<5){
                System.out.println("The number is lesser than the given no.");
            }
            else if(n!=randomNumber && x==5){
                System.out.println("Sorry57, You are out of tries");
                System.out.println("The correct answer is " + randomNumber);
                System.out.println("Better luck next time");
            }
            else{
                System.out.println("You have succesfully guessed the no.");
                break;
            }
            x++;
        }
    }
}
