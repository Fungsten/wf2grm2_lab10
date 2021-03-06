/*
Will Fung and Grace Mazzarella
have made a better version of this in Player.java

import structure5.*;
import java.util.Random;

public class RandomPlayer implements Player{
  protected char color;

  public RandomPlayer(char color){
    this.color = color;
  }

  // pre: node is a non-null GameNode node; opponent is the player to play after this player
  // post: game is played from this node on, winning player is returned
  public Player play(GameNode node, Player opponent){
    // Heavily modeled after HexBoard's main method
    HexBoard board = node.currBoard;
    Vector<HexMove> moves = node.currBoard.moves(node.color);
    System.out.println(node.toSillyString());
    Random rand = new Random();
    int rpMove = rand.nextInt(moves.size());
    board = new HexBoard(board, moves.elementAt(rpMove));
    System.out.println("This is the current board:");
    System.out.println(board.toString());

    if (board.win(this.color)){
      // If RandomPlayer wins, return RandomPlayer
      System.out.println("A monkey on a typewriter wins!");
      return this;
    } else {
      // If RandomPlayer didn't win, return opponent so that play may continue
      return opponent;
    }
  }
}
*/
