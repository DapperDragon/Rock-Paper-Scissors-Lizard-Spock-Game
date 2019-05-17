/*
    Rock Paper Scissors Lizard Spock
    Developed 16/05/19 by Gary Hughes
 */

//inport Scanner for player input
//Random for AI move
package bigbangspock;
import java.util.Scanner;
import java.util.Random;

public class BigBangSpock {
    
    //global variables for tracking scores
    public static Integer playerScore = 0;
    public static Integer computerScore = 0;
    
    public static void main(String[] args) {
        
        //player choice used by switch statement for play moves
        //integer in to handle input mismatch
        Integer playerChoice = null;
        Integer round = 1;
        boolean integerIn = false;
        
        //do/while 1 to loop menu until exit game is chosen
        //do/while 2 to loop input section incase of input mismatch
        do{  
            do{
                System.out.println("\n1 - Quit Game");
                System.out.println("2 - Show Rules");
                System.out.println("3 - Rock");
                System.out.println("4 - Paper");
                System.out.println("5 - Sharp Things");
                System.out.println("6 - Lizard");
                System.out.println("7 - Spock\n");

                //handle input mismatch, boolean integerIn to exit do/while
                Scanner in = new Scanner(System.in);
                    if(in.hasNextInt()) {
                        playerChoice = in.nextInt();
                        integerIn = true;
                    }else{
                        System.out.println("Please input numbers only");
                        integerIn = false;
                    }
                }while(integerIn == false);
            

            //switch for all player choices given in menu
            switch(playerChoice){
                
            case 1: //quit game - self explanatory
                System.out.println("Thanks for playing!");
                System.exit(0);
                break;
                
            case 2: //show rules given by The Big Bang Theory's Sheldon
                System.out.println("Scissors cuts paper, "
                    + "\n" + "paper covers rock, rock crushes lizard, "
                    + "\n" + "lizard poisons Spock, Spock smashes scissors, "
                    + "\n" + "scissors decapitates lizard, lizard eats paper, "
                    + "\n" + "paper disproves Spock, Spock vaporizes rock, "
                    + "\n" + "and as it always has, rock crushes scissors.");
                break;
                
            case 3: //player uses Rock
                System.out.println("Round #" + round + "\n");
                System.out.println("You have chosen: Rock");
                gameLogic(playerChoice, round);
                round++;
                break;
                
            case 4: // player uses paper
                System.out.println("Round #" + round + "\n");
                System.out.println("You have chosen: Paper");
                gameLogic(playerChoice, round);
                round++;
                break;
                
            case 5: // player uses scissors
                System.out.println("Round #" + round + "\n");
                System.out.println("You have chosen: Scissors");
                gameLogic(playerChoice, round);
                round++;
                break;
                
            case 6: //player uses lizard
                System.out.println("Round #" + round + "\n");
                System.out.println("You have chosen: Lizard");
                gameLogic(playerChoice, round);
                round++;
                break;
                
            case 7: // player uses spock
                System.out.println("Round #" + round + "\n");
                System.out.println("You have chosen: Spock");
                gameLogic(playerChoice, round);
                round++;
                break;

            default: //integer is input, but does not match an option in the menu
                System.out.println("invalid choice error");
            }        

        }while(playerChoice != 1);
    }

    static void gameLogic(Integer playerChoice, Integer round) {

        //random number is generated between 1 and 5
        //number matched to lis of moves
        //assigned to "computerChoice" and showen to player
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(5);
        String[] choices = new String[] {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
        String computerChoice = choices[randomInt];
        System.out.println("Your opponent has chosen: " + computerChoice);


        //switch uses player choice - 3 as it is the same variable used in the previous switch
        //the options to quit game and show rules where showen before the rules
        //so the -3 brings the variable in line with the list of moves the AI 
        switch(playerChoice - 3){
            case 0://player uses rock, AI used Lizard OR scissors

                //player wins scenario
                if(computerChoice == "Lizard" || computerChoice == "Scissors"){

                    //print moves of both AI and Player, show scores, break switch
                    System.out.println("Rock Crushes " + computerChoice + " - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                    
                //tie scenario
                }else if(computerChoice == "Rock"){
                    //show scores, break switch
                    System.out.println("It's A Tie");
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                    
                //AI wins scenario
                }else{
                    //AI uses spock to win
                    if(computerChoice == "Spock"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your rock is vaporized by the opponent! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;
                    //AI uses paper to win
                    }else if(computerChoice == "Paper"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your rock is covered by the paper! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;   
                    }
                }

            case 1://player uses paper
                
                //player wins, AI uses Rock
                if(computerChoice == "Rock"){
                    System.out.println("Paper Covers Rock - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
               
                //Player wins, AI uses Spock
                }else if(computerChoice == "Spock"){
                    System.out.println("Paper disproves spock - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;

                //Tie
                }else if(computerChoice == "Paper"){
                    System.out.println("It's A Tie");
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                
                //AI wins
                }else{
                    //AI uses scissors to win
                    if(computerChoice == "Scissors"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Scissors cut your Paper! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;
                    //AI uses lizard to win
                    }else if(computerChoice == "Liazrd"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your Paper is eaten! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;   
                    }
                }

            case 2: //scissors
                
                //play wins, AI uses paper
                if(computerChoice == "Paper"){
                    System.out.println("Scissors cut the paper - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                    
                //player wins, AI uses Lizard
                }else if (computerChoice == "Lizard"){
                    System.out.println("Scissors decapitate the lizard - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;                            
                }
                
                //Tie
                else if(computerChoice == "Scissors"){
                    System.out.println("It's A Tie");
                    break;
                    
                //AI wins
                }else{
                    //AI uses rock to win
                    if(computerChoice == "Rock"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your scissors are, as always, crushed by rock! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;
                    //AI uses spock to win
                    }else if(computerChoice == "Spock"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Spock smashes your scissors! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;   
                    }
                }


            case 3://lizard
                if(computerChoice == "Spock"){
                    System.out.println("The lizard poisons spock - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                }else if(computerChoice == "Paper"){
                    System.out.println("The lizard eats the paper - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                }else if(computerChoice == "Lizard"){
                    System.out.println("It's A Tie");
                    break;
                }else{
                    //AI uses rock to win
                    if(computerChoice == "Rock"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your lizard is crushed! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;
                    //AI uses Scissors to win
                    }else if(computerChoice == "Scissors"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Your lizard is decapitated! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;   
                    }
                }


            case 4: //spock
                if(computerChoice == "Scissors"){
                    System.out.println("Spock smashes the scissors - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;
                }else if(computerChoice == "Rock"){
                    System.out.println("Spock vaporized the rock - player wins!");
                    playerScore++;
                    System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                    break;



                }else if(computerChoice == "Spock"){
                    System.out.println("It's A Tie");
                    break;
                }else{
                    //AI uses lizard to win
                    if(computerChoice == "Lizard"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Spock is poisoned by the opponent! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;
                    //AI uses paper to win
                    }else if(computerChoice == "Paper"){
                        //print moves of both AI and Player, show scores, break switch
                        System.out.println("Spock is disproved by the paper! - Computer Wins");
                        computerScore++;
                        System.out.println("\nPlayer  V  Computer" + "\n" + playerScore + "\t-\t" + computerScore);
                        break;   
                    }
                }
                
            default: //handle any moves unaccounted for
                System.out.println("Game Logic Error");
                break;
                
        }
    }
}
