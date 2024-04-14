import java.util.Scanner;
import java.util.Random;
// user defined exception
class InvalidInputException extends Exception
{
    InvalidInputException(String msg)
    {
        super(msg);
    }
}
class Game
{
    int user_choice;
    int computer_choice;
    // taking input from users.
    int input() throws InvalidInputException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter '0' for rock, '1' for Scissor ,'2' for paper:");
        user_choice = sc.nextInt();
        sc.close();
        if(user_choice > 2)
        {
            throw new InvalidInputException("Invalid input. Please choose number from 0 to 2.");
        }
        return user_choice;
    }
    // generating random number for computer
    int Number_generator()
    {
        Random r =  new Random();
        computer_choice = r.nextInt(3);
        System.out.println("Computer choice: "+"\n"+ computer_choice);
        return computer_choice;
    }

    // decide the winner by comparing the input they have assigned
    void compare()
    {
        if(user_choice == 0 && computer_choice == 1)
            System.out.println("You Win!!🎉");    
        else if(user_choice == 1 && computer_choice == 2) 
            System.out.println("You Win!!🎉");
        else if(user_choice == 2 && computer_choice == 0)
            System.out.println("You Win!!🎉");
        else if(user_choice == computer_choice)
            System.out.println("Match Draw....");
        else
            System.out.println("You lose!!😔");
    }
    void loop()
    {
        boolean is_con = true;
        while(is_con)
        {
            try
            {
                input();
            }
            catch(InvalidInputException nee)
            {
                System.out.println(nee.getMessage());
            }
            finally{
                Number_generator();
                compare();
            }
        }    
    }

}

public class RPSGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String want_to_continue;
        Game g =  new Game();
        g.loop();
        System.out.println("Do you want to continue? Type 'y' or 'n':");
        want_to_continue = s.next();
        if(want_to_continue.equals("yes"))
        {
            g.loop();
        }else{
            System.out.println("Thank you for playing!!");
        }
        s.close();
    }
}
