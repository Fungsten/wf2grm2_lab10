// Basic layout provided by Duane A. Bailey
// (c) 2000, 2001 duane a. bailey
// Heavy modification done by Will Fung and Grace Mazzarella
import java.util.Random;
import java.util.Scanner;
import structure5.*;

public class Player {
  protected char color;
  protected String type;
  protected GameNode newNode;
  protected GameTree gametree;

  public Player(String type, char color){
    this.color = color;
    if (type.equals("h")){
      this.type = "human";
    } else if (type.equals("r")){
      this.type = "random";
    } else if (type.equals("c")){
      this.type = "AI";
    } else {
      System.out.println("You input an invalid type and will be pitted against the AI. You only have yourself to blame.");
      this.type = "AI";
    }
  }

  // Pre: takes a non-null GameNode and a valid player
  // Post: if no one has won, returns a GameNode based on the chosen move
  //       if someone has won, returns the input GameNode
  public GameNode play(GameNode node, Player opponent){
    HexBoard board = node.currBoard;
    Vector<GameNode> moves = node.children;
    GameNode result = node;
    System.out.println(node.toSillyString());


    //ich bin ein human
    if (this.type.equals("human")){
      Scanner in = new Scanner(System.in);
      System.out.println("Please type one of the given integers: ");
      int hMove = in.nextInt() + 1;
      if (hMove > moves.size()){
        System.out.println("You have input an invalid move. If you choose to type an invalid move again, you will forfeit the game.");
        hMove = in.nextInt() + 1;
        if (hMove > moves.size()){
          //result = node;
          System.out.println("You're not very good at this, are you, mate?");
        } else {
          board = new HexBoard(board, moves.elementAt(hMove).hm);
        }
      }
      System.out.println("This is the current board:");
      System.out.println(board.toString());

      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(hMove).hm);
      //System.out.println("This is the current board:");
      //System.out.println(newNode.currBoard.toString());
    }


    //ich bin ein dumb
    else if (this.type.equals("random")){
      Random rand = new Random();
      int rpMove = rand.nextInt(moves.size());

      board = new HexBoard(board, moves.elementAt(rpMove).hm);
      System.out.println("This is the current board:");
      System.out.println(board.toString());

      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(rpMove).hm);
      //System.out.println("This is the current board:");
      //System.out.println(newNode.currBoard.toString());
    }


    //I AM A ROBOT. BEEP BOOP.
    else {
      Random rand = new Random();
      int aiMove = rand.nextInt(moves.size());

      board = new HexBoard(board, moves.elementAt(aiMove).hm);
      System.out.println("This is the current board:");
      System.out.println(board.toString());

      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(aiMove).hm);
      //System.out.println("This is the current board:");
      //System.out.println(newNode.currBoard.toString());
    }


    if (newNode.currBoard.win(this.color)){
      if (this.type.equals("human")){
        // If HumanPlayer wins, return corresponding node
        System.out.println("The human actually triumphs!");
        //result = node;

      } else if (this.type.equals("random")){
        // If randomPlayer wins, return corresponding node
        System.out.println("A monkey on a typewriter wins! Seriously?");
        //result = node;

      } else if (this.type.equals("AI")){
        // If our new robot overlord wins, return corresponding node
        System.out.println("Our new robot overlord triumphs! You have doomed us all.");
        //result = node;

      } else {
        // If nobody won, return the next node;
        result = newNode;
      }
    }
    return result;
  }
}
