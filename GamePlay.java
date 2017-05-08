//This is the file you should run to grade our project
//by the illustrious Grace Mazzarella and the absurd Will Fung (whose last name is not Fury)

import java.util.Scanner;
import structure5.*;

public class GamePlay{

  GameTree root;
  Player p1;
  Player p2;
  int p1Wins;
  int p2Wins;
  int i = 2000; //number of iterations or games played between computer / random players


  //we have a GamePlay object thing which takes the arguments of player one's type, its color assignment
  //and then the same for player two
  public GamePlay(String playerOne, String colorOne, String playerTwo, String colorTwo){
    this.root = new GameTree();
    if (playerOne.equals("h")){
      this.p1 = new Player(playerOne);
    } else if (playerOne.equals("r")){
      this.p1 = new Player(playerOne);
    } else {
      this.p1 = new Player(playerOne);
    }
    this.p1.setColor(colorOne);
    if (playerTwo.equals("h")){
      this.p2 = new Player(playerTwo);
    } else if (playerTwo.equals("r")){
      this.p2 = new Player(playerTwo);
    } else {
      this.p2 = new Player(playerTwo);
    }
    this.p2.setColor(colorTwo);
    this.p1Wins = 0;
    this.p2Wins = 0;
  }

  protected Player oppPlayer(Player currPlayer){
    if (currPlayer.equals(this.p1)){
      return this.p2;
    } else {
      return this.p1;
    }
  }

  //this makes the game actually go
  public void go(){ //well, we're not actually playing Go here, nor is it really chess...but you get the drift
    Player currPlayer = this.p1;
    GameNode playedNode = this.root.groot;

    // play two moves, remove the null state of the two players current nodes
    // we can't set the two players current nodes to the root or else the while loop won't execute
    // P1 plays once
    currPlayer.play(playedNode, oppPlayer(currPlayer));
    playedNode = currPlayer.currNode;
    currPlayer = this.oppPlayer(currPlayer);
    // P2 plays once
    currPlayer.play(playedNode, oppPlayer(currPlayer));
    playedNode = currPlayer.currNode;
    currPlayer = this.oppPlayer(currPlayer);

    // Play continues until there is a winner
    while (!currPlayer.currNode.equals(playedNode) && playedNode.isWin == false){
      currPlayer.play(playedNode, oppPlayer(currPlayer));
      playedNode = currPlayer.currNode;
      currPlayer = this.oppPlayer(currPlayer);
      //if (playedNode.isWin ==  true){
        //break;
      //}
    }

    //the following tallies total wins per player
    if (currPlayer.equals(this.p1)){
      System.out.println("Player One wins!");
      ++this.p1Wins;
    } else {
      System.out.println("Player Two wins!");
      ++this.p2Wins;
    }

    System.out.println(playedNode.toSillyString()); //prints out final board state


    // Ask to play again
    if (this.p1.type.equals("human") || this.p2.type.equals("human")){
      Scanner in = new Scanner(System.in);
      System.out.println("Would the human(s) like to play again?");
      System.out.println("Type 'y' for yes and 'n' for no.");
      String answer = in.nextLine();
      if (answer.equals("y")){
        this.go();
      } else if (answer.equals("n")){
        return;
      } else {
        System.out.println("You did not input a valid answer. If you input a second invalid answer, you will quit and lose all progress.");
        String answer2 = in.nextLine();
        if (answer2.equals("y")){
          this.go();
        } else if (answer2.equals("n")){
          return;
        } else {
          System.out.println("You have quit");
          return;
        }
      }
    } else { //this is for when pitting two computers or randoms in some combination against each other
      //to simulate many games at once
      while (i > 0){
        i--;
        this.go();
      }
    }
  }



  public static void main(String args[]){
    // RELEASE THE KRAKEN
    Scanner in = new Scanner(System.in);
    System.out.println("Player 1: please input 'h' to play as yourself, 'r' to watch a random player play, or 'c' to watch a learning computer play.");
    String arg1 = in.next();
    System.out.println("Player 1: please input 'w' to play as white and go first or 'b' to play as black and go second.")
    String arg2 = in.next();
    System.out.println("Player 2: please input 'h' to play as yourself, 'r' to watch a random player play, or 'c' to watch a learning computer play.");
    String arg3 = in.next();
    System.out.println("Player 2: please input 'w' to play as white and go first or 'b' to play as black and go second.")
    String arg4 = in.next();
    GamePlay hexapawn = new GamePlay(arg1, arg2, arg3, arg4);*/

    //GamePlay hexapawn = new GamePlay("r", "w", "j", "b");

    hexapawn.go();
    System.out.println("P1 wins: " + hexapawn.p1Wins);
    System.out.println("P2 wins: " + hexapawn.p2Wins);
  }

}
