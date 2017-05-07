/*
Will Fung and Grace Mazzarella
*/

import structure5.*;
import java.util.Scanner;

public class HumanPlayer implements Player{
  protected char hColor;

  public HumanPlayer(char color){
    this.hColor = color;
  }

  // pre: node is a non-null GameNode node; opponent is the player to play after this player
  // post: game is played from this node on, winning player is returned
  public Player play(GameNode node, Player opponent){
    // Heavily modeled after HexBoard's main method
    HexBoard board = node.currBoard;
    Vector<HexMove> moves = node.currBoard.moves(node.color);
    System.out.println(node.toSillyString());
    Scanner in = new Scanner(System.in);
    System.out.println("Please type one of the given integers: ");
    int hMove = in.nextInt();
    board = new HexBoard(board, moves.elementAt(hMove));
    System.out.println("This is the current board:");
    System.out.println(board.toString());

    if (board.win(this.hColor)){
      // If HumanPlayer wins, return HumanPlayer
      System.out.println("The human triumphs!");
      return this;
    } else {
      // If HumanPlayer didn't win, return opponent so that play may continue
      return opponent;
    }
  }
}
