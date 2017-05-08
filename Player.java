// Basic layout provided by Duane A. Bailey
// (c) 2000, 2001 duane a. bailey
// Heavy modification done by Will Fung and Grace Mazzarella

//important note: we have taken the liberty of setting up the board such the side
//on the bottom is white and the top is black
//because complaints from a chess player

import java.util.Random;
import java.util.Scanner;
//import java.util.Math;
import structure5.*;

public class Player {
  protected char color;
  protected String type;
  protected GameNode currNode;
  //protected GameTree gametree;

  //this creates a player of a certain type determined by the input string
  public Player(String type){
    this.color = HexBoard.WHITE; // a default that is changed in GamePlay.java
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
    this.currNode = null;
  }


  //this sets the color of a particular player
  //pre: literally anything, we have decided to make it idiot-proof
  public void setColor(String color){
    if (color.equals("b")){
      this.color = HexBoard.WHITE; //chess player's liberty coming in, basically telling you this is purposeful for a stylistic reason
    } else if (color.equals("w")){
      this.color = HexBoard.BLACK;
    } else {
      System.out.println("You input an invalid choice and have automatically been assigned to white.");
      this.color = HexBoard.BLACK;
    }
  }

  // Pre: takes a non-null GameNode and a valid player
  // Post: if no one has won, returns a GameNode based on the chosen move
  //       if someone has won, returns the input GameNode
  public GameNode play(GameNode node, Player opponent){
    HexBoard board = node.currBoard;
    Vector<GameNode> moves = node.children;
    GameNode newNode;
    System.out.println(node.toSillyString());


    //ich bin ein human
    if (this.type.equals("human")){
      System.out.println(this.color + " to move:");
      Scanner in = new Scanner(System.in);
      System.out.println("Please type one of the given integers: ");
      int hMove = in.nextInt() - 1;
      if (hMove > moves.size()){
        System.out.println("You have input an invalid move. If you choose to type an invalid move again, you will forfeit the game.");
        hMove = in.nextInt() + 1;
        if (hMove > moves.size()){
          //result = node;
          System.out.println("You're not very good at this, are you, mate?");
          return node;
        } else {
          board = new HexBoard(board, moves.elementAt(hMove).hm);
        }
      }
      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(hMove).hm);
    }


    //ich bin ein dumb
    else if (this.type.equals("random")){
      Random rand = new Random();
      System.out.println("moves.size: " + moves.size());
      int rpMove = rand.nextInt(moves.size());

      board = new HexBoard(board, moves.elementAt(rpMove).hm);
      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(rpMove).hm);
    }


    //I AM A ROBOT. BEEP BOOP.
    else {
      Random rand = new Random();
      int aiMove = rand.nextInt(moves.size());

      board = new HexBoard(board, moves.elementAt(aiMove).hm);
      newNode = new GameNode(board.win(color), board, opponent.color, node, moves.elementAt(aiMove).hm);

      //prunes are dried plums
      if (!newNode.currBoard.win(this.color) || newNode.isWin == true){
        //kills the grandparent node to prevent because the parent node is the opponent's play
        //to avoid going down this branch at the control of the current player, this must be done
        newNode.removeChild(newNode.getParent().getParent());
      }
    }


/*

  The following win check is purely for flavor. It has been kept here only for the purposes of posterity.

    if (newNode.currBoard.win(this.color) || newNode.isWin == true){
      // If there's a win, return a silly String and outside all of this return the current node
      if (this.type.equals("human")){
        System.out.println("The human actually triumphs!");
        return this.currNode;
      } else if (this.type.equals("random")){
        System.out.println("A monkey on a typewriter wins! Seriously?");
        return this.currNode;
      } else {
        System.out.println("Our new robot overlord triumphs! You have doomed us all.");
        return this.currNode;
      }
    } else {
      // If nobody won, update the current node and return it
      //System.out.println("No one won");
      for (int i = 0; i < node.children.size(); ++i){
        if (newNode.hm.equals(node.children.elementAt(i).hm)){
          this.currNode = node.children.elementAt(i);
        }
      }
      return this.currNode;
    }
*/


    //for obtaining the moves available for the next turn
    for (int i = 0; i < node.children.size(); ++i){
      if (newNode.hm.equals(node.children.elementAt(i).hm)){
        this.currNode = node.children.elementAt(i);
      }
    }
    return this.currNode;
  }
}
