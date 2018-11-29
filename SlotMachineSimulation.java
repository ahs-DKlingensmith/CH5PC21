
/**
 * Dylan Klingensmith
 * CH5PC21 - Slot Machine Simulation
 * AP Computer Science
 * 11/29/18
 */

import java.util.Scanner;
import java.util.Random;

public class SlotMachineSimulation {

    public static void main(String[] args) {

        //Establish scanner, randomizer, and variables
        Random randomizer = new Random();
        Scanner keyboard = new Scanner(System.in);

        int bet, winnings;
        int totalBets = 0;
        int totalWinnings = 0;
        
        char playAgain = 'Y';
        String input;

        int randomNumber;
        String[] results = new String[3];

        while (playAgain == 'Y') {

            System.out.println("Input the amount of money you wish to bet.");
            bet = keyboard.nextInt();
            totalBets += bet;

            for (int x = 0; x < 3; x++) {

                randomNumber = randomizer.nextInt(6);
                switch (randomNumber) {
                    case 0:
                        results[x] = "Cherries";
                        break;
                    case 1:
                        results[x] = "Oranges";
                        break;
                    case 2:
                        results[x] = "Plums";
                        break;
                    case 3:
                        results[x] = "Bells";
                        break;
                    case 4:
                        results[x] = "Melons";
                        break;
                    case 5:
                        results[x] = "Bars";
                        break;
                }

                System.out.println(results[x]);

            }

            if (results[0].equals(results[1]) && results[0].equals(results[2])) {

                winnings = bet * 3;
                totalWinnings += winnings;
                System.out.println("Jackpot! You earn $" + winnings);

            } else if (results[0].equals(results[1])
                    || results[0].equals(results[2]) || results[1].equals(results[2])) {

                winnings = bet * 2;
                totalWinnings += winnings;
                System.out.println("You earn $" + winnings);

            } else {

                System.out.println("Sorry. You earn $0");

            }
            
            System.out.println("Do you want to play again? (Y/N)");
            input = keyboard.next();
            input = input.toUpperCase();
            playAgain = input.charAt(0);
            
            if (!(playAgain == 'Y' || playAgain == 'N'))    {
                System.out.println("That is not a valid response.");
                input = keyboard.next();
                input = input.toUpperCase();
                playAgain = input.charAt(0);
            }

        }
        
        System.out.println("Total bets:\t" + totalBets);
        System.out.println("Total winnings:\t" + totalWinnings);
        
        

    }

}
